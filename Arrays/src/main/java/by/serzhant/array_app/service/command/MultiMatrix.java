package by.serzhant.array_app.service.command;

import by.serzhant.array_app.entity.Matrix;
import by.serzhant.array_app.service.exception.ExecuteException;
import by.serzhant.array_app.service.util.MatrixOperation;
import by.serzhant.array_app.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 Класс содержит исполняющий метод для команды перемножение матриц
 */

public class MultiMatrix implements Command {
    private static final Logger LOGGER = LogManager.getLogger(MultiMatrix.class);
    private Validator validator = new Validator();
    private MatrixOperation matrixOperation;
    private Matrix<?> firstMatrix;
    private Matrix<?> secondMatrix;

    public MultiMatrix(Matrix<?> firstMatrix, Matrix<?> secondMatrix, MatrixOperation matrixOperation) {
        this.matrixOperation = matrixOperation;
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
    }

    @Override
    public Object execute() throws ExecuteException {
        if (!validator.isValidMatrix(firstMatrix)) {
            LOGGER.error(ERROR_MESSAGE);
            throw new ExecuteException(Command.ERROR_MESSAGE);
        }

        if (!validator.isValidMatrix(secondMatrix)) {
            LOGGER.error(ERROR_MESSAGE);
            throw new ExecuteException(Command.ERROR_MESSAGE);
        }

        if (!validator.isValidForMultiplication(firstMatrix, secondMatrix)) {
            LOGGER.error("Matrixs invalid for multiplication");
            throw new ExecuteException(Command.ERROR_MESSAGE);
        }

        LOGGER.info(SUCCESS_EXECUTION_MESSAGE);
        return matrixOperation.multiplicationMatrix(firstMatrix, secondMatrix);
    }
}
