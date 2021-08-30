package by.serzhant.array.controller;

import by.serzhant.array.entity.Array;
import by.serzhant.array.entity.Matrix;
import by.serzhant.array.service.ArrayBuilder;
import by.serzhant.array.service.MatrixBuilder;
import by.serzhant.array.service.command.*;
import by.serzhant.array.service.util.MatrixOperation;
import by.serzhant.array.service.util.Sort;

import java.util.HashMap;
import java.util.Map;

public class CommandsFactory {
    private static final CommandsFactory instance = new CommandsFactory();

    private final Map<String, Command> allCommands = new HashMap<>();

    public CommandsFactory() {
        MatrixOperation matrixOperation = new MatrixOperation();
        Sort sort = new Sort();

        ArrayBuilder arrayBuilder = new ArrayBuilder();
        Array<?> array = new Array<>(arrayBuilder.getArray());

        MatrixBuilder matrixBuilder = new MatrixBuilder();

        matrixBuilder.build("1");
        Matrix<?> firstMatrix = new Matrix<>(matrixBuilder.getMatrix());

        matrixBuilder.build("2");
        Matrix<?> secondMatrix = new Matrix<>(matrixBuilder.getMatrix());

        allCommands.put("1", new BubbleSort(array, sort));
        allCommands.put("2", new ShakerSort(array, sort));
        allCommands.put("3", new SelectionSort(array, sort));
        allCommands.put("4", new InsertionSort(array, sort));
        allCommands.put("5", new MergeSort(array, sort));
        allCommands.put("6", new ShellSort(array, sort));
        allCommands.put("7", new HashSort(array, sort));
        allCommands.put("8", new SumMatrix(firstMatrix, secondMatrix, matrixOperation));
        allCommands.put("9", new SubtractMatrix(firstMatrix, secondMatrix, matrixOperation));
        allCommands.put("10", new MultiMatrix(firstMatrix, secondMatrix, matrixOperation));
        allCommands.put("invalidParam", new ExceptionCommand());
    }

    public static CommandsFactory getInstance() {
        return instance;
    }

    public Command getCommand(String sortName) {

        if (!allCommands.containsKey(sortName)) {
            sortName = "invalidParam";
        }

        return allCommands.get(sortName);
    }
}
