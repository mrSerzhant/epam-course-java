package by.serzhant.array_app.service.command;

import by.serzhant.array_app.service.exception.ExecuteException;

/**
 Класс содержит исполняющий метод для команды ошибка выполнения
 */

public class ExceptionCommand implements Command {

    @Override
    public Object execute() throws ExecuteException {
        throw new ExecuteException("invalid input param");
    }
}
