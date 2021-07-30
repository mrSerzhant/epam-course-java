package by.serzhant.app.executors;

import by.serzhant.app.entity.Numeral;
import by.serzhant.app.services.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TimeTransformer implements Executable{
    private static final Logger LOGGER = LogManager.getLogger(CalculateMath.class);
    private static final String TIME_PATTERN = "HHч MMмин SSс";
    private Numeral timeInSeconds;
    private String result;

    public TimeTransformer(){
        initTime();
        execute();
    }

    private void initTime(){
        Reader reader = new Reader();

        timeInSeconds = new Numeral((int)reader.readPositiveNumeral());
        LOGGER.info(String.format("Входной элемент %d", timeInSeconds.getRealNumeral()));
    }

    @Override
    public void execute() {
        int hours = timeInSeconds.getRealNumeral() / 3600;
        int minutes = (timeInSeconds.getRealNumeral() - hours * 3600) / 60;
        int seconds = timeInSeconds.getRealNumeral() - hours * 3600 - minutes * 60;

        result = TIME_PATTERN.replace("HH", String.valueOf(hours)).replace("MM", String.valueOf(minutes)).replace("SS", String.valueOf(seconds));
        LOGGER.info("Расчет выполнен, результат - ." + result);
    }

    @Override
    public String getResult() {
        return result;
    }
}
