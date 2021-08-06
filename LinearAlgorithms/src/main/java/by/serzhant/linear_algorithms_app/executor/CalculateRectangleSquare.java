package by.serzhant.linear_algorithms_app.executor;

import by.serzhant.linear_algorithms_app.entity.Figure;
import by.serzhant.linear_algorithms_app.service.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalculateRectangleSquare implements Executable {
    private static final Logger LOGGER = LogManager.getLogger(CalculateRectangleSquare.class);
    private Figure figure;
    private String result;

    public CalculateRectangleSquare() {
        initFigure();
        execute();
    }

    private void initFigure() {
        Reader reader = new Reader();
        figure = new Figure(reader.readPositiveNumeral());
        LOGGER.info("Входной элемент {}, Постоянный элемент {}", figure.getFirstSide(), figure.getSecondSide());
    }

    @Override
    public void execute() {
        result = String.valueOf(figure.getFirstSide() * figure.getSecondSide());
        LOGGER.info("Расчет выполнен, результат - {}", result);
    }

    @Override
    public String getResult() {
        return result;
    }
}
