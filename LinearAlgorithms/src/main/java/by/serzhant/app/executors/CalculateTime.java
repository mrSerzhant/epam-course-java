package by.serzhant.app.executors;

import by.serzhant.app.entity.Numeral;
import by.serzhant.app.entity.Time;
import by.serzhant.app.services.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalculateTime implements Executable {
    private static final Logger LOGGER = LogManager.getLogger(CalculateTime.class);
    private Time time;
    private Numeral inputSeconds;
    private Numeral inputMinutes;
    private Numeral inputHours;
    private String result;

    public CalculateTime() {
        initTime();
        execute();
    }

    private void initTime() {
        Reader reader = new Reader();
        time = new Time();

        System.out.println("Количество часов");
        time.setHour(new Numeral((int) reader.readValidHours()));

        System.out.println("Количество минут");
        time.setMinute(new Numeral((int) reader.readValidTime()));

        System.out.println("Количество секунд");
        time.setSecond(new Numeral((int) reader.readValidTime()));

        System.out.println("Изменить время на n часов:");
        inputHours = new Numeral((int) reader.readPositiveNumeral());

        System.out.println("Изменить время на n минут:");
        inputMinutes = new Numeral((int) reader.readPositiveNumeral());

        System.out.println("Изменить время на n секунд:");
        inputSeconds = new Numeral((int) reader.readPositiveNumeral());

        LOGGER.info(String.format("Заданное время - %dч-%dм-%dс, изменить на %dч, %dм, %dс", time.getHour().getRealNumeral(), time.getMinute().getRealNumeral(), time.getSecond().getRealNumeral(),
                inputHours.getRealNumeral(), inputMinutes.getRealNumeral(), inputSeconds.getRealNumeral()));
    }

    @Override
    public void execute() {
        int tempHoursValue;
        int tempMinutesValue;

        time.setSecond(new Numeral(time.getSecond().getRealNumeral() + inputSeconds.getRealNumeral()));

        if (time.getSecond().getRealNumeral() > 59) {
            tempHoursValue = time.getSecond().getRealNumeral() / 3600;
            time.setHour(new Numeral(time.getHour().getRealNumeral() + tempHoursValue));
            tempMinutesValue = (time.getSecond().getRealNumeral() - (tempHoursValue * 3600)) / 60;
            time.setMinute(new Numeral(time.getMinute().getRealNumeral() + tempMinutesValue));
            time.setSecond(new Numeral(time.getSecond().getRealNumeral() - (tempHoursValue * 3600 + tempMinutesValue * 60)));
        }

        time.setMinute(new Numeral(time.getMinute().getRealNumeral() + +inputMinutes.getRealNumeral()));

        if (time.getMinute().getRealNumeral() > 59) {
            tempHoursValue = time.getMinute().getRealNumeral() / 60;
            time.setHour(new Numeral(time.getHour().getRealNumeral() + tempHoursValue));
            time.setMinute(new Numeral(time.getMinute().getRealNumeral() - tempHoursValue * 60));
        }

        time.setHour(new Numeral(time.getHour().getRealNumeral() + inputHours.getRealNumeral()));

        if (time.getHour().getRealNumeral() > 23) {
            tempHoursValue = time.getHour().getRealNumeral() / 23;
            time.setHour(new Numeral(time.getHour().getRealNumeral() - tempHoursValue * 23));
        }

        result = String.format("%dч - %dм - %dс", time.getHour().getRealNumeral(), time.getMinute().getRealNumeral(), time.getSecond().getRealNumeral());
        LOGGER.info(String.format("Время изменено, новые значения %dч, %dм, %dс", time.getHour().getRealNumeral(), time.getMinute().getRealNumeral(), time.getSecond().getRealNumeral()));
    }

    @Override
    public String getResult() {
        return result;
    }
}
