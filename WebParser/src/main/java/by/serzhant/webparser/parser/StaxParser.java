package by.serzhant.webparser.parser;

import by.serzhant.webparser.entity.Gem;
import by.serzhant.webparser.entity.NaturalGem;
import by.serzhant.webparser.entity.SynthesizedGem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StaxParser implements Parsable {
    private static final Logger LOGGER = LogManager.getLogger(StaxParser.class);
    private static final String FIRST_TYPE_TAG = "naturalGem";
    private static final String SECOND_TYPE_TAG = "synthesizedGem";
    private static final String PRECIOUSNESS_TAG = "preciousness";
    private static final String ORIGIN_TAG = "origin";
    private static final String COLOR_TAG = "color";
    private static final String TRANSPARENCY_TAG = "transparency";
    private static final String FACET_TAG = "facet";
    private static final String WEIGHT_TAG = "weight";
    private static final String MININGMETHOD_TAG = "miningMethod";
    private static final String CREATIONDATE_TAG = "creationDate";

    @Override
    public List<Gem> parse(String filePath) {
        List<Gem> gemList = new ArrayList<>();
        String name = "";
        int ID = 0;
        String price = "";
        String preciousness = "";
        String origin = "";
        String color = "";
        double transparency = 0;
        int facet = 0;
        double weight = 0;
        String miningMethod = "";
        String creationDate = "";

        String currentElement = "";

        try {
            XMLStreamReader xmlReader = XMLInputFactory.newFactory().createXMLStreamReader(filePath, new FileInputStream(filePath));
            LOGGER.info("xmlReader успешно получен");

            while (xmlReader.hasNext()) {
                xmlReader.next();
                LOGGER.info("Следующий элемент существует");

                if (xmlReader.isStartElement()) {
                    currentElement = xmlReader.getLocalName();
                    LOGGER.info("Старт тега: {}", currentElement );

                    if (currentElement.equals(FIRST_TYPE_TAG) || currentElement.equals(SECOND_TYPE_TAG)) {
                        name = xmlReader.getAttributeValue(0);
                        LOGGER.info("Значение name: {}", name);

                        ID = Integer.parseInt(xmlReader.getAttributeValue(1));
                        LOGGER.info("Значение ID: {}", ID);

                        if (xmlReader.getAttributeValue(2) != null) {
                            price = xmlReader.getAttributeValue(2);
                            LOGGER.info("Значение price: {}", price);
                        }
                    }
                } else if (xmlReader.hasText()) {
                    LOGGER.info("Текущий элемент текст");

                    switch (currentElement) {
                        case PRECIOUSNESS_TAG:
                            preciousness = xmlReader.getText();
                            LOGGER.info("Значение preciousness: {}", preciousness);
                            break;
                        case ORIGIN_TAG:
                            origin = xmlReader.getText();
                            LOGGER.info("Значение origin: {}", origin);
                            break;
                        case COLOR_TAG:
                            color = xmlReader.getText();
                            LOGGER.info("Значение color: {}", color);
                            break;
                        case TRANSPARENCY_TAG:
                            transparency = Double.parseDouble(xmlReader.getText());
                            LOGGER.info("Значение transparency: {}", transparency);
                            break;
                        case FACET_TAG:
                            facet = Integer.parseInt(xmlReader.getText());
                            LOGGER.info("Значение facet: {}", facet);
                            break;
                        case WEIGHT_TAG:
                            weight = Double.parseDouble(xmlReader.getText());
                            LOGGER.info("Значение weight: {}", weight);
                            break;
                        case MININGMETHOD_TAG:
                            miningMethod = xmlReader.getText();
                            LOGGER.info("Значение miningMethod: {}", miningMethod);
                            break;
                        case CREATIONDATE_TAG:
                            creationDate = xmlReader.getText();
                            LOGGER.info("Значение creationDate: {}", creationDate);
                            break;
                    }
                } else if (xmlReader.isEndElement()) {
                    currentElement = xmlReader.getLocalName();

                    LOGGER.info("Конец тега: {}", currentElement);

                    if (currentElement.equals(FIRST_TYPE_TAG) || currentElement.equals(SECOND_TYPE_TAG)) {
                        switch (currentElement) {
                            case FIRST_TYPE_TAG:
                                gemList.add(new NaturalGem(name, ID, price, preciousness, origin, color, transparency, facet, weight, miningMethod));
                                LOGGER.info("Обьект типа NaturalGem создан");
                                break;
                            case SECOND_TYPE_TAG:
                                gemList.add(new SynthesizedGem(name, ID, price, preciousness, origin, color, transparency, facet, weight, creationDate));
                                LOGGER.info("Обьект типа SynthesizedGem создан");
                                break;
                        }
                    }
                    currentElement = "";
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            LOGGER.error("xmlReader ошибка получения");
        }

        return gemList;
    }
}
