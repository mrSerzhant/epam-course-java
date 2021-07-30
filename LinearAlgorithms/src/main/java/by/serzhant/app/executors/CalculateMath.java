package by.serzhant.app.executors;

import by.serzhant.app.entity.Numeral;
import by.serzhant.app.services.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalculateMath implements Executable {
    private static final Logger LOGGER = LogManager.getLogger(CalculateMath.class);
    public static final double EXPONENT = 3;
    private Reader reader = new Reader();
    private Numeral firstNumeral;
    private Numeral secondNumeral;
    private String result;

    public CalculateMath() {
        initNumerals();
        execute();
    }

    private void initNumerals() {
        firstNumeral = new Numeral(reader.readNumeral());
        secondNumeral = new Numeral(reader.readNumeral());
        LOGGER.info(String.format("Входной элемент 1 - %f, Входной элемент 2 - %f, Степень - %f", firstNumeral.getValidNumeral(), secondNumeral.getValidNumeral(), EXPONENT));
    }

    @Override
    public void execute() {
        while (true) {
            System.out.println("Введите 1 - среднее арифметическое чисел, 2 - среднее геометрическое чисел, 0 - выход");

            switch ((int) reader.readNumeral()) {
                case 1:
                    result = String.valueOf((Math.pow(firstNumeral.getValidNumeral(), EXPONENT) + Math.pow(secondNumeral.getValidNumeral(), EXPONENT)) / 2);
                    LOGGER.info("Арифм. расчет выполнен - ." + result);
                    return;
                case 2:
                    result = String.valueOf((Math.sqrt(Math.abs(firstNumeral.getValidNumeral()) * Math.abs(secondNumeral.getValidNumeral()))));
                    LOGGER.info("Геометр. расчет выполнен - ." + result);
                    return;
                case 0:
                    result = "Расчет не выполнен";
                    LOGGER.warn("Выбор не сделан");
                    return;
                default:
                    System.out.println("Ошибка");
            }
        }
    }

    @Override
    public String getResult() {
        return result;
    }
}
