package by.serzhant.uml.view.consoleprocessing.utils;

import by.serzhant.uml.view.consoleprocessing.ConsolePrinter;
import by.serzhant.uml.view.consoleprocessing.ConsoleReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Request {
    private ConsoleReader reader = new ConsoleReader();

    public Map<String, ArrayList<String>> doChoice(String nameRequest, ConsolePrinter consolePrinter) {
        consolePrinter.printInfoMessage("enter_car_number");

        return doResponse(nameRequest);
    }

    public Map<String, ArrayList<String>> addFuel(String nameRequest, ConsolePrinter consolePrinter) {
        consolePrinter.printInfoMessage("enter_amount_fuel");

        return doResponse(nameRequest);
    }

    public Map<String, ArrayList<String>> addWheel(String nameRequest, ConsolePrinter consolePrinter) {
        consolePrinter.printInfoMessage("enter_wheel_diameter");

        return doResponse(nameRequest);
    }

    private Map<String, ArrayList<String>> doResponse(String inputNameRequest){
        ArrayList<String> list = new ArrayList<>();
        list.add(reader.readInputValue());

        Map<String, ArrayList<String>> response = new HashMap<>();
        response.put(inputNameRequest, list);

        return response;
    }
}
