package by.serzhant.tasks.task17;

import by.serzhant.tasks.Utils;

public class Task17 {
    private static final double exponent = 3;
    private double firstInputValue;
    private double secondInputValue;
    private double arithmeticResult;
    private double geometricResult;

    public Task17() {
        initInputValue();
        calculateResult();
        getResult();
    }

    private void initInputValue() {
        firstInputValue = Utils.getInputValue();
        secondInputValue = Utils.getInputValue();
    }

    private void calculateResult() {
        arithmeticResult = (Math.pow(firstInputValue, exponent) + Math.pow(secondInputValue, exponent)) / 2;
        geometricResult = (Math.sqrt(Math.abs(firstInputValue) * Math.abs(secondInputValue)));
    }

    private void getResult() {

        while (true) {
            System.out.println("Введите 1 - среднее арифметическое чисел, 2 - среднее геометрическое чисел, 0 - выход");

            switch (Utils.getInputNaturalValue()) {
                case 1:
                    Utils.printResult(Double.toString(arithmeticResult));
                    break;
                case 2:
                    Utils.printResult(Double.toString(geometricResult));
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Ошибка");
            }
        }
    }
}
