package by.serzhant.uml.service.command;

import by.serzhant.uml.controller.CommandProvider;
import by.serzhant.uml.dal.DataReader;
import by.serzhant.uml.dal.DataWriter;
import by.serzhant.uml.entity.Car;

import by.serzhant.uml.service.util.DataParser;
import by.serzhant.uml.service.validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class AddFuel implements Command {
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

        int currentCapacity = car.getFuelTank().getCapacity();

        Map<String, ArrayList<String>> request = CommandProvider.userRequest;
        Object key = request.keySet().toArray()[0];
        List<String> requestData = request.get(key);

        if (!validator.isValidFuelCapacity(key.toString())) {
            return "invalid_fuel_amount";
        }

        int inputFuelCapacity = Integer.parseInt(requestData.get(0));
        car.getFuelTank().setCapacity(currentCapacity + inputFuelCapacity);

        List<String> listAllCar = dataReader.readDataFile();

        DataWriter writer = new DataWriter();
        writer.writeTempData(car);
        writer.reWriteData(listTempCar, listAllCar, car);

        return "add " + inputFuelCapacity + " " + car;
    }
}
