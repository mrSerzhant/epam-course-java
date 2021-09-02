package by.serzhant.uml.view.consoleprocessing.requestcommand;

import by.serzhant.uml.view.consoleprocessing.ConsolePrinter;
import by.serzhant.uml.view.consoleprocessing.utils.Request;

import java.util.ArrayList;
import java.util.Map;

public class RequestCountFuel implements RequestCommand {
    @Override
    public Map<String, ArrayList<String>> execute(String nameCommand, ConsolePrinter consolePrinter) {
        Request request = new Request();
        return request.addFuel(nameCommand, consolePrinter);
    }
}
