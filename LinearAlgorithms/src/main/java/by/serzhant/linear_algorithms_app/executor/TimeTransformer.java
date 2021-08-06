package by.serzhant.linear_algorithms_app.executor;

import by.serzhant.linear_algorithms_app.entity.Numeral;
import by.serzhant.linear_algorithms_app.service.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TimeTransformer implements Executable {
    private static final Logger LOGGER = LogManager.getLogger(TimeTransformer.class);
    private static final String TIME_PATTERN = "HHч MMмин SSс";
    private Numeral timeInSeconds;
    private String result;

    public TimeTransformer() {
        initTime();
        execute();
    }

    private void initTime() {
        Reader reader = new Reader();

        timeInSeconds = new Numeral((int) reader.readPositiveNumeral());
        LOGGER.info("Входной элемент {}", timeInSeconds.getRealNumeral());
    }

    @Override
    public void execute() {
        final int SECONDS_PER_HOUR = 3600;
        final int SECOND_PER_MINUTE = 60;
        int hours = timeInSeconds.getRealNumeral() / SECONDS_PER_HOUR;
        int minutes = (timeInSeconds.getRealNumeral() - hours * SECONDS_PER_HOUR) / SECOND_PER_MINUTE;
        int seconds = timeInSeconds.getRealNumeral() - hours * SECONDS_PER_HOUR - minutes * SECOND_PER_MINUTE;

        result = TIME_PATTERN.replace("HH", String.valueOf(hours)).replace("MM", String.valueOf(minutes)).replace("SS", String.valueOf(seconds));
        LOGGER.info("Расчет выполнен, результат - {}", result);
    }

    @Override
    public String getResult() {
        return result;
    }
}
