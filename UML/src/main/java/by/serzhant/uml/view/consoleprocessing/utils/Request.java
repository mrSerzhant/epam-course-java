package by.serzhant.uml.view.consoleprocessing.utils;

import by.serzhant.uml.view.consoleprocessing.ConsolePrinter;
import by.serzhant.uml.view.consoleprocessing.ConsoleReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Request {
    private ConsoleReader reader = new ConsoleReader();

    public Map<String, ArrayList<String>> doChoice(String nameRequest, ConsolePrinter consolePrinter){
        consolePrinter.printInfoMessage("input_car_number");

        ArrayList<String> list = new ArrayList<>();
        list.add(reader.readInputValue());

        Map<String, ArrayList<String>> map = new HashMap<>();
        map.put(nameRequest, list);

        return map;
    }



    
}
