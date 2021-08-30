package by.serzhant.array.service.command;

import by.serzhant.array.service.exception.ExecuteException;

public interface Command {
    String SUCCESS_EXECUTION_MESSAGE = "SUCCESS EXECUTION";
    String ERROR_MESSAGE = "invalid_input_values";
    String VALID_PARAM = "PARAM IS VALID";


    Object execute() throws ExecuteException;
}
