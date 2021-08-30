package by.serzhant.uml.controller;

import by.serzhant.uml.entity.Car;
import by.serzhant.uml.entity.typecar.Sedan;
import by.serzhant.uml.service.command.*;


import java.util.HashMap;
import java.util.Map;

public class CommandsFactory {
    private final CommandsFactory instance = new CommandsFactory();
    private Map<String, Command> allCommands = new HashMap<>();

    public CommandsFactory() {
        Car car = new Sedan(null,null, null);

        allCommands.put("1", null);
        allCommands.put("2", new Move(car));
        allCommands.put("3", new GetInfo(car));
        allCommands.put("invalidParam", new ExceptionCommand());
    }

    public CommandsFactory getInstance() {
        return instance;
    }

    public Command getCommand(String sortName) {

        if (!allCommands.containsKey(sortName)) {
            sortName = "invalidParam";
        }

        return allCommands.get(sortName);
    }
}
