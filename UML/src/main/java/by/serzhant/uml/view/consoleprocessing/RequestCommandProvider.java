package by.serzhant.uml.view.consoleprocessing;

import by.serzhant.uml.view.consoleprocessing.requestcommand.RequestChoiceCar;
import by.serzhant.uml.view.consoleprocessing.requestcommand.RequestCommand;
import by.serzhant.uml.view.consoleprocessing.requestcommand.RequestCountFuel;
import by.serzhant.uml.view.consoleprocessing.requestcommand.RequestWheelInfo;

import java.util.HashMap;
import java.util.Map;

public class RequestCommandProvider {
    private final Map<String, RequestCommand> allCommands = new HashMap<>();

    public RequestCommandProvider() {
        allCommands.put("2", new RequestChoiceCar());
        allCommands.put("4", new RequestCountFuel());
        allCommands.put("5", new RequestWheelInfo());
    }

    public RequestCommand getCommand(String inputValue) {
        if (!allCommands.containsKey(inputValue)) {
            inputValue = "invalidParam";
        }

        return allCommands.get(inputValue);
    }
}
