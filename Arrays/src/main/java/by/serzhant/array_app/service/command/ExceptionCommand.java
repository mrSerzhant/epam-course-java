package by.serzhant.array_app.service.command;

import by.serzhant.array_app.entity.Array;
import by.serzhant.array_app.service.exception.SortException;

public class ExceptionCommand implements Command {

    @Override
    public Array<?> sort() throws SortException {
        throw new SortException("invalid input param");
    }
}