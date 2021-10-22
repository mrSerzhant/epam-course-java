package by.serzhant.webparser.parser;

import by.serzhant.webparser.entity.Gem;
import by.serzhant.webparser.entity.NaturalGem;
import by.serzhant.webparser.entity.SynthesizedGem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DomParser implements Parsable {
    private static final Logger LOGGER = LogManager.getLogger(DomParser.class);

    @Override
    public List<Gem> parse(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = factory.newDocumentBuilder();
            LOGGER.info("documentBuilder успешно создан");

        } catch (ParserConfigurationException e) {
            LOGGER.error("documentBuilder ошибка создания: {}", e.getMessage());
        }

        Document document = null;
        try {
            document = documentBuilder.parse(filePath);
            LOGGER.info("парсинг файла в память был успешно выполнен");
        } catch (SAXException | IOException e) {
            LOGGER.error("парсинг файла в память не был выполнен : {}", e.getMessage());
        }

        Element root = document.getDocumentElement();
        List<Gem> gemList = new ArrayList<>();

        gemList.addAll(createElement(root, "naturalGem"));
        LOGGER.info("Список элементов типа {} успешно создан", "naturalGem");
        gemList.addAll(createElement(root, "synthesizedGem"));
        LOGGER.info("Список элементов типа {} успешно создан", "synthesizedGem");

        return gemList;
    }

    private Gem buildGem(Element gem) {
        String name = gem.getAttribute("name");
        LOGGER.info("Значение name: {}", name);

        int ID = Integer.parseInt(gem.getAttribute("ID"));
        LOGGER.info("Значение ID: {}", ID);

        String price = "";

        if (gem.getAttribute("price") != null) {
            price = gem.getAttribute("price");
        }
        LOGGER.info("Значение price: {}", price);

        String preciousness = getElementTextContent(gem, "preciousness");
        LOGGER.info("Значение preciousness: {}", preciousness);

        String origin = getElementTextContent(gem, "origin");
        LOGGER.info("Значение origin: {}", origin);

        String color = getElementTextContent(gem, "color");
        LOGGER.info("Значение color: {}", color);

        double transparency = Double.parseDouble(getElementTextContent(gem, "transparency"));
        LOGGER.info("Значение transparency: {}", transparency);

        int facet = Integer.parseInt(getElementTextContent(gem, "facet"));
        LOGGER.info("Значение facet: {}", facet);

        double weight = Integer.parseInt(getElementTextContent(gem, "weight"));
        LOGGER.info("Значение weight: {}", weight);

        String miningMethod = getElementTextContent(gem, "miningMethod");
        LOGGER.info("Значение miningMethod: {}", miningMethod);

        String creationDate = getElementTextContent(gem, "creationDate");
        LOGGER.info("Значение creationDat: {}", creationDate);

        if (miningMethod != null) {
            LOGGER.info("Обьект типа NaturalGem создан");
            return new NaturalGem(name, ID, price, preciousness, origin, color, transparency, facet, weight, miningMethod);
        } else {
            LOGGER.info("Обьект типа SynthesizedGem создан");
            return new SynthesizedGem(name, ID, price, preciousness, origin, color, transparency, facet, weight, creationDate);
        }
    }

    private String getElementTextContent(Element gemElement, String gemName) {
        NodeList list = gemElement.getElementsByTagName(gemName);

        if (list.getLength() == 0) {
            return null;
        }

        return list.item(0).getTextContent();
    }

    private List<Gem> createElement(Element root, String tagName) {
        List<Gem> gemList = new ArrayList<>();
        NodeList elementsList = root.getElementsByTagName(tagName);

        for (int i = 0; i < elementsList.getLength(); i++) {
            Element gemElement = (Element) elementsList.item(i);
            gemList.add(buildGem(gemElement));
        }

        return gemList;
    }

}
