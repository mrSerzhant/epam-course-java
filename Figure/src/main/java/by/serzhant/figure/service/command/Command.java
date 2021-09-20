package by.serzhant.figure.service.command;

import by.serzhant.figure.exeption.ExecuteException;


public interface Command {

    Object execute() throws ExecuteException;
}
