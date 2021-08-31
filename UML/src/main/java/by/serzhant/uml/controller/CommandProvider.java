package by.serzhant.uml.controller;

import by.serzhant.uml.entity.Car;
import by.serzhant.uml.entity.typecar.Sedan;
import by.serzhant.uml.service.command.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<String, Command> allCommands = new HashMap<>();
    private Map<String, ArrayList<String>> tempData ;

    public CommandProvider(){
        Car car;
        allCommands.put("1", new GetListCar());
      /*  allCommands.put("1", new ChoiceCar(car, tempData.get("1")));
        allCommands.put("2", new Move(car));
        allCommands.put("3", new GetInfo(car));
        allCommands.put("invalidParam", new ExceptionCommand());*/
    }

    public Command getCommand(Map<String, ArrayList<String>> inputData) {
        Object commandName = inputData.keySet().toArray()[0];

        if (!allCommands.containsKey(commandName.toString())) {
            return allCommands.get("invalidParam");
        }

        tempData = inputData;

        return allCommands.get(commandName.toString());
    }
}
