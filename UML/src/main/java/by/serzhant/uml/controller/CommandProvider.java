package by.serzhant.uml.controller;

import by.serzhant.uml.entity.Car;
import by.serzhant.uml.entity.typecar.Sedan;
import by.serzhant.uml.service.command.Command;
import by.serzhant.uml.service.command.ExceptionCommand;
import by.serzhant.uml.service.command.GetInfo;
import by.serzhant.uml.service.command.Move;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<String, Command> allCommands = new HashMap<>();

    public CommandProvider(){
        Car car = new Sedan(null,null, null);

        allCommands.put("1", null);
        allCommands.put("2", new Move(car));
        allCommands.put("3", new GetInfo(car));
        allCommands.put("invalidParam", new ExceptionCommand());
    }

    public Command getCommand(String sortName) {
        if (!allCommands.containsKey(sortName)) {
            sortName = "invalidParam";
        }

        return allCommands.get(sortName);
    }
}
