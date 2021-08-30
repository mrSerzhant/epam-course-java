package by.serzhant.uml.view.consoleprocessing;

import java.util.ArrayList;
import java.util.Map;

public class RequestController {
    private final RequestCommandProvider provider = new RequestCommandProvider();
    private ConsolePrinter consolePrinter;

    public RequestController(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public Map<String, ArrayList<String>> execute(String inputValue) {
        Map<String, ArrayList<String>> request;

        request = provider.getCommand(inputValue).execute(inputValue, consolePrinter);



   /*     try {
            response =
        } catch (Exception e) {
            response = e.getMessage();
        }*/

        return request;
    }
}
