package by.serzhant.array_app.service.command;

import by.serzhant.array_app.service.exception.ExecuteException;

/**
 Класс содержит исполняющий метод, который создает ошибку в случае отсутствие коректной команды
 */

public class ExceptionCommand implements Command {

    @Override
    public Object execute() throws ExecuteException {
        throw new ExecuteException("invalid input param");
    }
}
