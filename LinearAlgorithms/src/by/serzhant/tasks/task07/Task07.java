package by.serzhant.tasks.task07;

import by.serzhant.tasks.Utils;

public class Task07 {
    private double width;
    private double length;
    private double result;

    public Task07() {
        doChoice();
        calculateResult();
        Utils.printResult(Double.toString(result));

    }

    private void doChoice() {
        double tempSide;

        while (true) {
            System.out.println("Введите 1, чтобы задать ширину или 2 - длину прямоугольника");

            switch (Utils.getInputNaturalValue()) {
                case 1:
                    System.out.println("Размер ширины:");
                    tempSide = Utils.getInputValue();

                    if (isPositiveValue(tempSide)) {
                        width = tempSide;
                        return;
                    }

                    break;
                case 2:
                    System.out.println("Размер длины:");
                    tempSide = Utils.getInputValue();

                    if (isPositiveValue(tempSide)) {
                        length = tempSide;
                        return;
                    }

                    break;
                default:
                    System.out.println("Ошибка");
                    break;
            }
        }
    }

    private void calculateResult() {
        if (width == 0) {
            result = length * (length / 2);
        } else {
            result = width * (width * 2);
        }
    }

    private boolean isPositiveValue(double inputValue) {
        return inputValue > 0;
    }
}
