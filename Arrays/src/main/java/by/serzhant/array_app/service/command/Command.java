package by.serzhant.array_app.service.command;

import by.serzhant.array_app.entity.Message;

public interface Command {
    String SUCCESS_EXECUTION_MESSAGE = "Результат выполнения";
    String ERROR_MESSAGE = "invalid_input_values";
    String SUCCESS_MESSAGE = "Сортировка завершена";
    String NO_MESSAGE = "no";
    String YES_MESSAGE = "yes";
    String INVALID_RESULT_MESSAGE = "invalid_result";

    Message sort();
}
