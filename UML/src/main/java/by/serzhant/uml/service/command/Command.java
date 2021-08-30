package by.serzhant.uml.service.command;

import by.serzhant.uml.service.exception.ExecuteException;

public interface Command {

    Object execute() throws ExecuteException;
}
