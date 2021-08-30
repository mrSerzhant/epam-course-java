package by.serzhant.uml.service.command;

import by.serzhant.uml.dal.DataReader;
import by.serzhant.uml.entity.Car;
import by.serzhant.uml.service.exception.ExecuteException;
import by.serzhant.uml.service.util.DataParser;
import by.serzhant.uml.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ChoiceCar implements Command {
    private static final Logger LOGGER = LogManager.getLogger(ChoiceCar.class);
    private Validator validator = new Validator();
    private Car car;
    private List<String> listData;


    public ChoiceCar(Car inputCar, List<String> listInputData) {
        this.car = inputCar;
        this.listData = listInputData;
    }

    @Override
    public Object execute() throws ExecuteException {
        DataReader reader = new DataReader();
        List<String> stringList = reader.readDaoFile();

        DataParser dataParser = new DataParser();
        List<Car> listCar = dataParser.parse(stringList);

        if (validator.isCorrectCarNumber(listData.get(0), listCar)) {
            int numberCar = Integer.parseInt(listData.get(0));
            car = listCar.get(numberCar);
            LOGGER.info("{} {}", "Current Car", car);
            return car;
        }

        return "invalid_number_car";
    }
}
