package by.serzhant.figure.controller;

import by.serzhant.figure.service.command.Command;
import by.serzhant.figure.service.command.ExceptionCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<String, Command> allCommands = new HashMap<>();

    public CommandProvider() {

        allCommands.put("invalidParam", new ExceptionCommand());
    }

    public Command getCommand(String inputString) {
        if (!allCommands.containsKey(inputString)) {
            return allCommands.get("invalidParam");
        }

        return allCommands.get(inputString);
    }
}
