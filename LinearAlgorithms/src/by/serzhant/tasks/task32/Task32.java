package by.serzhant.tasks.task32;

import by.serzhant.tasks.utils.Utils;

public class Task32 {
    private int hours;
    private int minutes;
    private int seconds;
    private int inputHours;
    private int inputMinutes;
    private int inputSeconds;

    public Task32() {
        initTime();
        changeTime();
        Utils.printResult(String.format("%dч, %dм, %dс",hours,minutes,seconds));
    }

    private void initTime() {
        int tempInputValue;

        while (true) {
            System.out.println("Введите количество часов");
            tempInputValue = Utils.getInputSpecialNaturalValue();

            if (tempInputValue < 24) {
                hours = tempInputValue;
                break;
            }
        }

        while (true) {
            System.out.println("Введите количество минут");
            tempInputValue = Utils.getInputSpecialNaturalValue();

            if (tempInputValue < 60) {
                minutes = tempInputValue;
                break;
            }
        }

        while (true) {
            System.out.println("Введите количество секунд");
            tempInputValue = Utils.getInputSpecialNaturalValue();

            if (tempInputValue < 60) {
                seconds = tempInputValue;
                break;
            }
        }

        System.out.println("Изменить время на n часов:");
        inputHours = Utils.getInputNaturalValue();

        System.out.println("Изменить время на n минут:");
        inputMinutes = Utils.getInputNaturalValue();

        System.out.println("Изменить время на n секунд:");
        inputSeconds = Utils.getInputNaturalValue();
    }

    private void changeTime() {
        int tempHoursValue;
        int tempMinutesValue;

        seconds = seconds + inputSeconds;

        if (seconds > 59) {
            tempHoursValue = seconds / 3600;
            hours = hours + tempHoursValue;
            tempMinutesValue = (seconds - (tempHoursValue * 3600)) / 60;
            minutes = minutes + tempMinutesValue;
            seconds = seconds - (tempHoursValue * 3600 + tempMinutesValue * 60);
        }

        minutes = minutes + inputMinutes;

        if (minutes > 59) {
            tempHoursValue = minutes / 60;
            hours = hours + tempHoursValue;
            minutes = minutes - tempHoursValue * 60;
        }

        hours = hours + inputHours;

        if(hours > 23){
            tempHoursValue = hours / 23;
            hours = hours - tempHoursValue * 23;
        }
    }
}
