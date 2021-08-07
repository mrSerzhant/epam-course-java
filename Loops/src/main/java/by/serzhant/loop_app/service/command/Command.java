package by.serzhant.loop_app.service.command;

public interface Command {
    String SUCCESS_EXECUTION_MESSAGE = "Результат выполнения";
    String ERROR_MESSAGE = "Неверные входные данные";
    String NO_MESSAGE = "no";
    String YES_MESSAGE = "yes";
    String NOT_POSITIVE_RESULT_MESSAGE = "Нет положиительного результата";


    Object execute();
}
