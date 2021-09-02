package by.serzhant.uml.view.consoleprocessing.requestcommand;

import by.serzhant.uml.view.consoleprocessing.ConsolePrinter;

import java.util.ArrayList;
import java.util.Map;

public interface RequestCommand {
    Map<String, ArrayList<String>> execute(String nameCommand, ConsolePrinter consolePrinter);
}
