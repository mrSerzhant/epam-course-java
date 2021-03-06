package by.serzhant.branching_app.view.concole_processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
