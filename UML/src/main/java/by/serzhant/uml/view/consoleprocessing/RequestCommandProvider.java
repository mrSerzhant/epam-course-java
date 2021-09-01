package by.serzhant.uml.view.consoleprocessing;

import by.serzhant.uml.view.consoleprocessing.requestcommand.RequestChoice;
import by.serzhant.uml.view.consoleprocessing.requestcommand.RequestCommand;
import by.serzhant.uml.view.consoleprocessing.utils.Request;

import java.util.HashMap;
import java.util.Map;

public class RequestCommandProvider {
    private final Map<String, RequestCommand> allCommands = new HashMap<>();
    private Request request = new Request();

    public RequestCommandProvider() {
        allCommands.put("2", new RequestChoice());

    }

    public RequestCommand getCommand(String inputValue) {
        if (!allCommands.containsKey(inputValue)) {
            inputValue = "invalidParam";
        }

        return allCommands.get(inputValue);
    }
}
