package by.serzhant.uml.service.command;

import by.serzhant.uml.dal.DataReader;
import by.serzhant.uml.dal.DataWriter;
import by.serzhant.uml.dal.TempCarReader;
import by.serzhant.uml.entity.Car;
import by.serzhant.uml.service.util.DataParser;
import by.serzhant.uml.service.validator.Validator;

import java.util.List;

public class Move implements Command {
    private Validator validator = new Validator();

    @Override
    public Object execute() {
        DataReader dataReader = new DataReader();
        List<String> listTempCar = dataReader.readTempDataFile();
        DataParser dataParser = new DataParser();
        List<Car> listCar = dataParser.parse(listTempCar);

        if (!validator.isValidData(listCar)) {
            return "select_car";
        }

        Car car = listCar.get(0);

        if (!validator.isMovableCar(car)) {
            return "not_enough_amount_wheels";
        }

        String response = car.move();

        List<String> listAllCar = dataReader.readDataFile();

        DataWriter writer = new DataWriter();
        writer.writeTempData(car);
        writer.reWriteData(listTempCar, listAllCar, car);

        return response + " " + car;
    }
}
