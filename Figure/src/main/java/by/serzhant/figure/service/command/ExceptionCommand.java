package by.serzhant.figure.service.command;


import by.serzhant.figure.exeption.ExecuteException;

/**
 Класс содержит исполняющий метод для команды ошибка выполнения
 */

public class ExceptionCommand implements Command {

    @Override
    public Object execute() throws ExecuteException {
        throw new ExecuteException("invalid_input_values");
    }
}
