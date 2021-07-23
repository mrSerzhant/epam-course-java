package by.serzhant.tasks.task22;

import by.serzhant.tasks.utils.Utils;

public class Task22 {
    private static final String TIME_PATTERN = "HHч MMмин SSс";
    private int inputValue;
    private String result;

    public Task22() {
        initInputValue();
        timeTransform();
        Utils.printResult(result);
    }

    private void initInputValue() {
        System.out.println("Введите количество секунд");
        inputValue = Utils.getInputNaturalValue();
    }

    private void timeTransform() {
        int hours = inputValue / 3600;
        int minutes = (inputValue - hours * 3600) / 60;
        int seconds = inputValue - hours * 3600 - minutes * 60;

        result = TIME_PATTERN.replace("HH", String.valueOf(hours)).replace("MM", String.valueOf(minutes)).replace("SS", String.valueOf(seconds));
    }
}
