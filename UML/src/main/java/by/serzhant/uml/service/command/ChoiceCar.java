package by.serzhant.uml.service.command;

import by.serzhant.uml.controller.CommandProvider;
import by.serzhant.uml.dal.DataReader;
import by.serzhant.uml.dal.DataWriter;
import by.serzhant.uml.entity.Car;
import by.serzhant.uml.service.util.DataParser;
import by.serzhant.uml.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChoiceCar implements Command {
    private static final Logger LOGGER = LogManager.getLogger(ChoiceCar.class);

    @Override
    public Object execute() {
        Map<String, ArrayList<String>> request = CommandProvider.userRequest;
        Object key = request.keySet().toArray()[0];

        List<String> requestData = request.get(key);

        DataReader reader = new DataReader();
        List<String> stringList = reader.readDataFile();

        DataParser dataParser = new DataParser();
        List<Car> listCar = dataParser.parse(stringList);

        Validator validator = new Validator();

        if (validator.isCorrectCarNumber(requestData.get(0), listCar)) {
            int numberCar = Integer.parseInt(requestData.get(0));
            Car car = listCar.get(numberCar - 1);
            LOGGER.info("{} {}", "Current Car", car);

            DataWriter writer = new DataWriter();
            writer.writeTempData(car);

            return car;
        }

        return "invalid_number_car";
    }
}
