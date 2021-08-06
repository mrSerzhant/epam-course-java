package by.serzhant.linear_algorithms_app.executor;

import by.serzhant.linear_algorithms_app.entity.Function;
import by.serzhant.linear_algorithms_app.entity.Numeral;
import by.serzhant.linear_algorithms_app.service.Reader;
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
