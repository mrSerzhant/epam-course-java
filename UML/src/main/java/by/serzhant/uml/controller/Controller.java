package by.serzhant.uml.controller;

import java.util.ArrayList;
import java.util.Map;

public class Controller {
    private final CommandProvider provider = new CommandProvider();

    public Object executeTask(Map<String, ArrayList<String>> request) {
        Object response;

        try {
            response = provider.getCommand(request).execute();
        } catch (Exception e) {
            response = e.getMessage();
        }

        return response;
    }
}
