package by.serzhant.thread.service.command;

import by.serzhant.thread.exception.ExecuteException;

public interface Command {

    Object execute() throws ExecuteException;
}
