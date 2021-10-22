package by.serzhant.webparser.parser;

import by.serzhant.webparser.entity.Gem;
import by.serzhant.webparser.entity.NaturalGem;
import by.serzhant.webparser.entity.SynthesizedGem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaxParser implements Parsable {
    private static final Logger LOGGER = LogManager.getLogger(SaxParser.class);
    private static final String FIRST_TYPE_TAG = "naturalGem";
    private static final String SECOND_TYPE_TAG = "synthesizedGem";
    private static final String MAIN_TAG = "mainTag";
    private static final String PRECIOUSNESS_TAG = "preciousness";
    private static final String ORIGIN_TAG = "origin";
    private static final String COLOR_TAG = "color";
    private static final String TRANSPARENCY_TAG = "transparency";
    private static final String FACET_TAG = "facet";
    private static final String WEIGHT_TAG = "weight";
    private static final String MININGMETHOD_TAG = "miningMethod";
    private static final String CREATIONDATE_TAG = "creationDate";
    private static final String NAME_ATR = "name";
    private static final String ID_ATR = "ID";
    private static final String PRICE_ATR = "price";

    @Override
    public List<Gem> parse(String filePath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
            LOGGER.info("SAXParser успешно создан");
        } catch (ParserConfigurationException | SAXException e) {
            LOGGER.error("SAXParser ошибка создания {}", e.getMessage());
        }

        XMLReader xmlReader = null;
        try {
            xmlReader = parser.getXMLReader();
            LOGGER.info("XMLReader успешно создан");
        } catch (SAXException e) {
            LOGGER.error("XMLReader ошибка создания {}", e.getMessage());
        }
        SimpleGemHandler handler = new SimpleGemHandler();
        xmlReader.setContentHandler(handler);

        try {
            xmlReader.parse(filePath);
            LOGGER.info("Парсинг файла успешно выполнен");
        } catch (IOException | SAXException e) {
            LOGGER.error("Ошибка парсинга файла {}", e.getMessage());
        }

        return handler.gemList;
    }

    private class SimpleGemHandler extends DefaultHandler {
        private List<Gem> gemList = new ArrayList<>();
        private String name;
        private int ID;
        private String miningMethod;
        private String creationDate;
        private String price;
        private String preciousness;
        private String origin;
        private String color;
        private double transparency;
        private int facet;
        private double weight;
        private String currentElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;

            LOGGER.info("Старт тега: {}", qName);

            if (qName.equals(FIRST_TYPE_TAG) || qName.equals(SECOND_TYPE_TAG)) {
                currentElement = MAIN_TAG;
            }

            switch (currentElement) {
                case MAIN_TAG:
                    name = attributes.getValue(NAME_ATR);
                    LOGGER.info("Значение name: {}", name);

                    ID = Integer.parseInt(attributes.getValue(ID_ATR));
                    LOGGER.info("Значение ID: {}", ID);

                    if (attributes.getValue(PRICE_ATR) != null) {
                        price = attributes.getValue(PRICE_ATR);
                    } else {
                        price = "";
                    }
                    LOGGER.info("Значение price: {}", price);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            LOGGER.info("Конец тега: {}", qName);

            if (qName.equals(FIRST_TYPE_TAG) || qName.equals(SECOND_TYPE_TAG)) {

                if (miningMethod != null) {
                    gemList.add(new NaturalGem(name, ID, price, preciousness, origin, color, transparency, facet, weight, miningMethod));
                    LOGGER.info("Обьект типа NaturalGem создан");
                } else {
                    gemList.add(new SynthesizedGem(name, ID, price, preciousness, origin, color, transparency, facet, weight, creationDate));
                    LOGGER.info("Обьект типа SynthesizedGem создан");
                }
            }

            currentElement = null;
        }

        @Override
        public void characters(char[] ch, int start, int length){
            String text = new String(ch, start, length);

            LOGGER.info("Чтение текста: {}", text);

            if (currentElement != null) {

                switch (currentElement) {
                    case PRECIOUSNESS_TAG:
                        preciousness = text;
                        LOGGER.info("Значение preciousness: {}", preciousness);
                        break;
                    case ORIGIN_TAG:
                        origin = text;
                        LOGGER.info("Значение origin: {}", origin);
                        break;
                    case COLOR_TAG:
                        color = text;
                        LOGGER.info("Значение color: {}", color);
                        break;
                    case TRANSPARENCY_TAG:
                        transparency = Double.parseDouble(text);
                        LOGGER.info("Значение transparency: {}", transparency);
                        break;
                    case FACET_TAG:
                        facet = Integer.parseInt(text);
                        LOGGER.info("Значение facet: {}", facet);
                        break;
                    case WEIGHT_TAG:
                        weight = Double.parseDouble(text);
                        LOGGER.info("Значение weight: {}", weight);
                        break;
                    case MININGMETHOD_TAG:
                        creationDate = null;
                        miningMethod = text;
                        LOGGER.info("Значение miningMethod: {}", miningMethod);
                        break;
                    case CREATIONDATE_TAG:
                        miningMethod = null;
                        creationDate = text;
                        LOGGER.info("Значение creationDat: {}", creationDate);
                        break;
                }
            }
        }
    }
}
