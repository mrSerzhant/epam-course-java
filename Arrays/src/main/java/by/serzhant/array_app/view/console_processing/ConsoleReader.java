package by.serzhant.array_app.view.console_processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 Данный класс содержит метод, позволяющий считывать информация с консоли.
 */

public class ConsoleReader {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String readInputValue() {
        try {
            return reader.readLine();
        } catch (IOException exception) {
            return exception.toString();
        }
    }
}
