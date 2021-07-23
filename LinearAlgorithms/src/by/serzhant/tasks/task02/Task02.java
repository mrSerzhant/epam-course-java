package by.serzhant.tasks.task02;

import by.serzhant.tasks.utils.Utils;

public class Task02 {
    public static final int CONST_ELEMENT = 3;
    private double result;

    public Task02(){
        calculateResult();
        Utils.printResult(Double.toString(result));
    }

    private void calculateResult(){
        result = Utils.getInputValue() + CONST_ELEMENT;
    }
}
