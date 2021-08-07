package by.serzhant.loop_app.service.command;

public interface Command {
    String SUCCESS_EXECUTION_MESSAGE = "Результат выполнения";
    String ERROR_MESSAGE = "invalid_input_values";
    String NO_MESSAGE = "no";
    String YES_MESSAGE = "yes";
    String INVALID_RESULT_MESSAGE = "invalid_result";



    Object execute();
}
