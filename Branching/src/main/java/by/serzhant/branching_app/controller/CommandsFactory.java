package by.serzhant.branching_app.controller;

import by.serzhant.branching_app.service.commands.Command;
import by.serzhant.branching_app.service.commands.CompareNumber;

import java.util.HashMap;
import java.util.Map;

public class CommandsFactory {
    private static final CommandsFactory instance = new CommandsFactory();
    private Map<String, Command> allCommands = new HashMap<>();

    public CommandsFactory(){
        allCommands.put("2",new CompareNumber());
      /*  allCommands.put("",);
        allCommands.put("",);
        allCommands.put("",);
        allCommands.put("",);
        allCommands.put("",);
        allCommands.put("",);
        allCommands.put("",);
        allCommands.put("",);
        allCommands.put("",); */
    }

    public static CommandsFactory getInstance(){
        return instance;
    }

    public Command getCommand(String commandName) {
        if (commandName == null || commandName.isEmpty()) {
            throw new IllegalArgumentException("Неверный аргумент");
        }

        return allCommands.get(commandName);
    }
}
