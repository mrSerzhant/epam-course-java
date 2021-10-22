package by.serzhant.webparser.controller;

import by.serzhant.webparser.entity.Gem;
import by.serzhant.webparser.parser.DomParser;
import by.serzhant.webparser.parser.Parsable;
import by.serzhant.webparser.parser.SaxParser;
import by.serzhant.webparser.parser.StaxParser;
import by.serzhant.webparser.validator.FileValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)

@WebServlet(value = "/parse")
public class FirstServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(FirstServlet.class);
    private String fileName;
    private String typeParse;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uploadPath = getServletContext().getRealPath("/WEB-INF/classes/data");
        LOGGER.info("Путь загрузки файлов: {}", uploadPath);

        HttpSession session = request.getSession();

        for (Part part : request.getParts()) {
            if (part.getName().equals("typeParse")) {
                typeParse = request.getParameter("typeParse");
                LOGGER.info("Запрос получен typeParse: {}", typeParse);
            } else {
                if (!part.getSubmittedFileName().isEmpty()) {
                    fileName = UUID.randomUUID() + part.getSubmittedFileName();
                    LOGGER.info("Название загружаемого файла: {}", fileName);
                    part.write(uploadPath + File.separator + fileName);
                    LOGGER.info("Файл успешно загружен");
                } else {
                    session.setAttribute("response", "not file");
                    LOGGER.warn("Файл не загружен");
                    response.sendRedirect(request.getHeader("referer"));
                    LOGGER.info("ответ отправлен");
                    return;
                }
            }
        }

        URL xmlUrl = FirstServlet.class.getClassLoader().getResource("data/" + fileName);
        LOGGER.info("Путь к загруженному файлу: {}", xmlUrl);
        // xmlUrl = FirstServlet.class.getClassLoader().getResource("data/gems.xml");
        
        URL xsdUrl = FirstServlet.class.getClassLoader().getResource("data/gem.xsd");
        LOGGER.info("Путь к схеме: {}", xsdUrl);

        FileValidator validator = new FileValidator();

        if (validator.isValidXML(xmlUrl.getPath(), xsdUrl.getPath())) {
            switch (typeParse) {
                case "DOM":
                    DomParser domParser = new DomParser();
                    doResponse(domParser, xmlUrl, request);
                    LOGGER.info("Парсинг DOM и создание ответа выполнено");
                    break;
                case "SAX":
                    SaxParser saxParser = new SaxParser();
                    doResponse(saxParser, xmlUrl, request);
                    LOGGER.info("Парсинг SAX и создание ответа выполнено");
                    break;
                case "StAX":
                    StaxParser staxParser = new StaxParser();
                    doResponse(staxParser, xmlUrl, request);
                    LOGGER.info("Парсинг StAX и создание ответа выполнено");
                    break;
            }
            session.removeAttribute("response");
            getServletContext().getRequestDispatcher("/gemslist.jsp").forward(request, response);
            response.sendRedirect("parse");
            LOGGER.info("Ответ отправлен");
        } else {
            session.setAttribute("response", "File is not valid");
            response.sendRedirect(request.getHeader("referer"));
            LOGGER.warn("Файл не подходит, ответ отправлен");
        }
    }

    private void doResponse(Parsable typeParser, URL fileUrl, HttpServletRequest request) {
        List<Gem> list = typeParser.parse(fileUrl.getPath());

        request.setAttribute("typeParse", typeParse + " parsing");
        request.setAttribute("gems", list);
    }
}
