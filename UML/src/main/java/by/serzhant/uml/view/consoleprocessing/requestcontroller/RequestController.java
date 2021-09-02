package by.serzhant.uml.view.consoleprocessing.requestcontroller;

import by.serzhant.uml.view.consoleprocessing.ConsolePrinter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RequestController {
    private final RequestCommandProvider provider = new RequestCommandProvider();
    private ConsolePrinter consolePrinter;

    public RequestController(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public Map<String, ArrayList<String>> execute(String inputValue) {
        Map<String, ArrayList<String>> request;


        try {
            request = provider.getCommand(inputValue).execute(inputValue, consolePrinter);
        } catch (Exception e) {
            request = new HashMap<>();
            request.put(inputValue, new ArrayList<>());
        }

        return request;
    }
}
