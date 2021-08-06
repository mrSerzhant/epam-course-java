package by.serzhant.branching_app.service.command;

public interface Command {
    String SUCCESS_EXECUTION_MESSAGE = "Результат выполнения";
    String ERROR_MESSAGE = "Неверные входные данные";
    String No_VALUE = "no";
    String NOT_POSITIVE_RESULT_MESSAGE = "Нет положиительного результата";

    Object execute();

}
