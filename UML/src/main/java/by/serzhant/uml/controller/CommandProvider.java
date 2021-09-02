package by.serzhant.uml.controller;

import by.serzhant.uml.service.command.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<String, Command> allCommands = new HashMap<>();
    public static Map<String, ArrayList<String>> userRequest;

    public CommandProvider(){
        allCommands.put("1", new GetListCar());
        allCommands.put("2", new ChoiceCar());
        allCommands.put("3", new Move());
        allCommands.put("4", new AddFuel());
        allCommands.put("5", new AddWheel());
        allCommands.put("invalidParam", new ExceptionCommand());
    }

    public Command getCommand(Map<String, ArrayList<String>> inputData) {
        String commandName = (String)inputData.keySet().toArray()[0];

        if (!allCommands.containsKey(commandName)) {
            return allCommands.get("invalidParam");
        }

        userRequest = inputData;

        return allCommands.get(commandName);
    }

}
