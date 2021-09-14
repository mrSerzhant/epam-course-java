package by.serzhant.thread.service.command;

import by.serzhant.thread.exception.ExecuteException;

/**
 Класс содержит исполняющий метод для команды ошибка выполнения
 */

public class ExceptionCommand implements Command {

    @Override
    public Object execute() throws ExecuteException {
        throw new ExecuteException("invalid_input_values");
    }
}
