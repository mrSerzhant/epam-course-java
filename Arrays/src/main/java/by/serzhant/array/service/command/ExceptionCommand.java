package by.serzhant.array.service.command;

import by.serzhant.array.service.exception.ExecuteException;

/**
 Класс содержит исполняющий метод для команды ошибка выполнения
 */

public class ExceptionCommand implements Command {

    @Override
    public Object execute() throws ExecuteException {
        throw new ExecuteException("invalid_input_values");
    }
}
