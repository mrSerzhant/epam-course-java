package by.serzhant.tasks.task2;

import by.serzhant.tasks.Utils;

public class Task02 {
    public static final int constValue = 3;
    private double result;

    public Task02(){
        calculateResult();
        Utils.printResult(Double.toString(result));
    }

    private void calculateResult(){
        result = Utils.getInputValue() + constValue;
    }
}
