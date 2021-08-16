package by.serzhant.array_app.controller;

import by.serzhant.array_app.entity.Array;
import by.serzhant.array_app.service.ArrayBuilder;
import by.serzhant.array_app.service.ArraySorter;

import java.util.HashMap;
import java.util.Map;

public class SortsFactory {
    private static final SortsFactory instance = new SortsFactory();

    private Map<String, Object> allSorts = new HashMap<>();



    public SortsFactory()  {
        ArrayBuilder arrayBuilder = new ArrayBuilder();
        ArraySorter sorter = new ArraySorter();
        Array<?> array = new Array<>(arrayBuilder.getArray());

          allSorts.put("1", sorter.bubbleSort(array));

         allSorts.put("2", sorter.shakerSort(array));
        //   allCommands.put("17", new ChangeNumeral());
        //  allCommands.put("22", new SwapNumeral());
        //  allCommands.put("32", new FindPositiveSum());
    }

    public static SortsFactory getInstance() {
        return instance;
    }

    public Object  getSort(String sortName) {
        return allSorts.get(sortName);
    }
}
