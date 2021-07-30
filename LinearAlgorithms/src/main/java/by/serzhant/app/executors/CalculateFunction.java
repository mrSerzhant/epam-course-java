package by.serzhant.app.executors;

import by.serzhant.app.entity.Function;
import by.serzhant.app.entity.Numeral;
import by.serzhant.app.services.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalculateFunction implements Executable {
    private static final Logger LOGGER = LogManager.getLogger(CalculateFunction.class);
    private Function function;
    private String result;

    public CalculateFunction() {
        initFunction();
        execute();
    }

    private void initFunction() {
        Reader reader = new Reader();

        function = new Function(new Numeral(reader.readNumeral()));
        LOGGER.info("Входной элемент {}, Константа {}", function.getValidNumeral().getValidNumeral(), Function.CONST_ELEMENT);
    }

    @Override
    public void execute() {
        result = String.valueOf(function.getValidNumeral().getValidNumeral() + Function.CONST_ELEMENT);
        LOGGER.info("Расчет выполнен, результат - {}", result);
    }

    public String getResult() {
        return result;
    }
}
