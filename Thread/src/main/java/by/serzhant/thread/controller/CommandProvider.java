package by.serzhant.thread.controller;

import by.serzhant.thread.service.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<String, Command> allCommands = new HashMap<>();

    public CommandProvider() {
        allCommands.put("1", new BuildMatrix());
        allCommands.put("2", new SemaphoreExample());
        allCommands.put("3", new ReentrantLockExamole());
        allCommands.put("4", new CountDownLatchExample());
        allCommands.put("5", new CustomThreadExample());
        allCommands.put("invalidParam", new ExceptionCommand());
    }

    public Command getCommand(String inputString) {
        if (!allCommands.containsKey(inputString)) {
            return allCommands.get("invalidParam");
        }

        return allCommands.get(inputString);
    }
}
