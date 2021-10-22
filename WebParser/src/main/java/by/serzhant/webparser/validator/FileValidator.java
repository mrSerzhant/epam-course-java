package by.serzhant.webparser.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;

public class FileValidator {
    private static final Logger LOGGER = LogManager.getLogger(FileValidator.class);

    public boolean isValidXML(String filePath, String xsdPath) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);

        DocumentBuilder parser = null;

        try {
            parser = documentBuilderFactory.newDocumentBuilder();
            LOGGER.info("documentBuilder успешно создан");
        } catch (ParserConfigurationException e) {
            LOGGER.error("documentBuilder ошибка создания: {}", e.getMessage());
            return false;
        }
        Document document = null;
        try {
            document = parser.parse(filePath);
            LOGGER.info("парсинг файла в память был успешно выполнен");
        } catch (SAXException | IOException e) {
            LOGGER.error("парсинг файла в память не был выполнен : {}", e.getMessage());
            return false;
        }

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        Source schemaFile = new StreamSource(xsdPath);
        Schema schema = null;
        try {
            schema = factory.newSchema(schemaFile);
            LOGGER.info("Схема успешно создана");
        } catch (SAXException e) {
            LOGGER.error("Ошибка создания схемы");
            return false;
        }

        Validator validator = schema.newValidator();

        try {
            validator.validate(new DOMSource(document));
        } catch (SAXException | IOException e) {
            LOGGER.error("Ошибка валидации файла");
            return false;
        }

        LOGGER.info("Файл успешно провалидирован");
        return true;
    }
}
