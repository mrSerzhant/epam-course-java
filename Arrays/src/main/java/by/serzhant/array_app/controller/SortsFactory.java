package by.serzhant.array_app.controller;

import by.serzhant.array_app.entity.Array;
import by.serzhant.array_app.service.ArrayBuilder;
import by.serzhant.array_app.service.command.*;

import java.util.HashMap;
import java.util.Map;

public class SortsFactory {
    private static final SortsFactory instance = new SortsFactory();

    private Map<String, Command> allSorts = new HashMap<>();


    public SortsFactory() {
        ArrayBuilder arrayBuilder = new ArrayBuilder();
        Array<?> array = new Array<>(arrayBuilder.getArray());

        allSorts.put("1", new BubbleSort(array));
        allSorts.put("2", new ShakerSort(array));
        allSorts.put("3", new SelectionSort(array));
        allSorts.put("4", new InsertionSort(array));
        allSorts.put("5", new MergeSort(array));
        allSorts.put("6", new ShellSort(array));
        allSorts.put("invalidParam", new ExceptionCommand());
        //
        //  allCommands.put("22", new SwapNumeral());
        //  allCommands.put("32", new FindPositiveSum());
    }

    public static SortsFactory getInstance() {
        return instance;
    }

    public Command getCommand(String sortName) {

        if(!allSorts.containsKey(sortName)){
            sortName = "invalidParam";
        }

        return allSorts.get(sortName);
    }
}
