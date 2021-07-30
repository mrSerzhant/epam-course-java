package by.serzhant.app.executers;

import by.serzhant.app.entity.Figure;
import by.serzhant.app.services.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalculateRectangleSquare implements Executable {
    private static final Logger logger = LogManager.getLogger(CalculateRectangleSquare.class);
    private Figure figure;
    private String result;

    public CalculateRectangleSquare() {
        initFigure();
        execute();
    }

    private void initFigure() {
        Reader reader = new Reader();
        figure = new Figure(reader.readPositiveNumeral());
        logger.info(String.format("Входной элемент %f, Постоянный элемент %f", figure.getFirstSide(), figure.getSecondSide()));
    }

    @Override
    public void execute() {
        result = String.valueOf(figure.getFirstSide() * figure.getSecondSide());
        logger.info("Расчет выполнен, результат - ." + result);
    }

    @Override
    public String getResult() {
        return result;
    }
}
