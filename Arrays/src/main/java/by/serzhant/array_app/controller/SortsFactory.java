package by.serzhant.array_app.controller;

import by.serzhant.array_app.entity.Array;
import by.serzhant.array_app.entity.Matrix;
import by.serzhant.array_app.service.ArrayBuilder;
import by.serzhant.array_app.service.MatrixBuilder;
import by.serzhant.array_app.service.command.*;
import by.serzhant.array_app.service.util.MatrixOperation;

import java.util.HashMap;
import java.util.Map;

public class SortsFactory {
    private static final SortsFactory instance = new SortsFactory();

    private final Map<String, Command> allCommands = new HashMap<>();

    public SortsFactory() {
        MatrixOperation matrixOperation = new MatrixOperation();
        ArrayBuilder arrayBuilder = new ArrayBuilder();
        Array<?> array = new Array<>(arrayBuilder.getArray());

        MatrixBuilder matrixBuilder = new MatrixBuilder();

        matrixBuilder.build("1");
        Matrix<?> firstMatrix = new Matrix<>(matrixBuilder.getMatrix());

        matrixBuilder.build("2");
        Matrix<?> secondMatrix = new Matrix<>(matrixBuilder.getMatrix());

        allCommands.put("1", new BubbleSort(array));
        allCommands.put("2", new ShakerSort(array));
        allCommands.put("3", new SelectionSort(array));
        allCommands.put("4", new InsertionSort(array));
        allCommands.put("5", new MergeSort(array));
        allCommands.put("6", new ShellSort(array));
        allCommands.put("7", new HashSort(array));
        allCommands.put("8", new SumMatrix(firstMatrix, secondMatrix, matrixOperation));
        allCommands.put("9", new SubtractMatrix(firstMatrix, secondMatrix, matrixOperation));
        allCommands.put("invalidParam", new ExceptionCommand());
    }

    public static SortsFactory getInstance() {
        return instance;
    }

    public Command getCommand(String sortName) {

        if (!allCommands.containsKey(sortName)) {
            sortName = "invalidParam";
        }

        return allCommands.get(sortName);
    }
}
