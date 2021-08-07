package by.serzhant.loop_app.controller;

import by.serzhant.loop_app.service.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandsFactory {
    private static final CommandsFactory instance = new CommandsFactory();
    private Map<String, Command> allCommands = new HashMap<>();

    public CommandsFactory() {
        allCommands.put("2", new Loop());
        allCommands.put("7", new LoopWithStep());
        allCommands.put("17", new LoopWithStep2());
        allCommands.put("22", new LoopWithStep3());
        allCommands.put("32", new ValidatorInputString());
    }

    public static CommandsFactory getInstance() {
        return instance;
    }

    public Command getCommand(String commandName) {
        return allCommands.get(commandName);
    }
}
