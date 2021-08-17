package by.serzhant.array_app.controller;

import by.serzhant.array_app.entity.Array;
import by.serzhant.array_app.service.ArrayBuilder;
import by.serzhant.array_app.service.command.BubbleCommand;
import by.serzhant.array_app.service.command.SelectionCommand;
import by.serzhant.array_app.service.command.ShakerCommand;
import by.serzhant.array_app.service.command.Command;

import java.util.HashMap;
import java.util.Map;

public class SortsFactory {
    private static final SortsFactory instance = new SortsFactory();

    private Map<String, Command> allSorts = new HashMap<>();


    public SortsFactory() {
        ArrayBuilder arrayBuilder = new ArrayBuilder();
        Array<?> array = new Array<>(arrayBuilder.getArray());

        allSorts.put("1", new BubbleCommand(array));
        allSorts.put("2", new ShakerCommand(array));
        allSorts.put("17", new SelectionCommand(array));

        //
        //  allCommands.put("22", new SwapNumeral());
        //  allCommands.put("32", new FindPositiveSum());
    }

    public static SortsFactory getInstance() {
        return instance;
    }

    public Command getCommand(String sortName) {
        return allSorts.get(sortName);
    }
}
