package by.serzhant.tasks.task22;

import by.serzhant.tasks.Utils;

public class Task22 {
    private static final String timePattern = "HHч MMмин SSс";
    private int inputValue;
    private String result;

    public Task22(){
        initInputValue();
        timeTransform();
        Utils.printResult(result);
    }

    private void initInputValue(){
        inputValue = Utils.getInputNaturalValue();
    }

    private void timeTransform() {
        int hours = inputValue / 3600;
        int minutes = (inputValue - hours * 3600) / 60;
        int seconds = inputValue - hours * 3600 - minutes * 60;

        result = timePattern.replace("HH",String.valueOf(hours)).replace("MM",String.valueOf(minutes)).replace("SS",String.valueOf(seconds));
    }
}
