package by.serzhant.branching_app.controller;

import by.serzhant.branching_app.service.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandsFactory {
    private static final CommandsFactory instance = new CommandsFactory();
    private Map<String, Command> allCommands = new HashMap<>();

    public CommandsFactory() {
        allCommands.put("2", new CompareNumber());
        allCommands.put("7", new CalculateABSFunction());
        allCommands.put("17", new ChangeNumeral());
        allCommands.put("22", new SwapNumeral());
        allCommands.put("32", new FindPositiveSum());
    }

    public static CommandsFactory getInstance() {
        return instance;
    }

    public Command getCommand(String commandName) {
        return allCommands.get(commandName);
    }
}
