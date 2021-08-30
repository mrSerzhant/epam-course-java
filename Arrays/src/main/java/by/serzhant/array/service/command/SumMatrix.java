package by.serzhant.array.service.command;

import by.serzhant.array.entity.Matrix;
import by.serzhant.array.service.exception.ExecuteException;
import by.serzhant.array.service.util.MatrixOperation;
import by.serzhant.array.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 Класс содержит исполняющий мето для команды суммирование матриц.
 */

public class SumMatrix implements Command{
    private static final Logger LOGGER = LogManager.getLogger(SumMatrix.class);
    private Validator validator = new Validator();
    private MatrixOperation matrixOperation;
    private Matrix<?> firstMatrix;
    private Matrix<?> secondMatrix;

    public SumMatrix(Matrix<?> firstMatrix, Matrix<?> secondMatrix, MatrixOperation matrixOperation) {
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.matrixOperation = matrixOperation;
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

        if(!validator.isEqualMatrix(firstMatrix, secondMatrix)){
            LOGGER.error("Matrixs isnt equals");
            throw new ExecuteException(Command.ERROR_MESSAGE);
        }

        LOGGER.info(SUCCESS_EXECUTION_MESSAGE);
        return matrixOperation.sumMatrix(firstMatrix, secondMatrix);
    }
}
