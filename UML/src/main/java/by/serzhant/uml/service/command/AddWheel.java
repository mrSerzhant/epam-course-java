package by.serzhant.uml.service.command;

import by.serzhant.uml.controller.CommandProvider;
import by.serzhant.uml.dal.DataReader;
import by.serzhant.uml.dal.DataWriter;
import by.serzhant.uml.entity.Car;
import by.serzhant.uml.entity.Wheel;

import by.serzhant.uml.service.util.DataParser;
import by.serzhant.uml.service.validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddWheel implements Command {


    @Override
    public Object execute() {
        DataReader dataReader = new DataReader();
        List<String> listTempCar = dataReader.readTempDataFile();

        DataParser dataParser = new DataParser();
        List<Car> listCar = dataParser.parse(listTempCar);

        Validator validator = new Validator();

        if (!validator.isValidData(listCar)) {
            return "select_car";
        }

        Car car = listCar.get(0);
        int countWheels = car.getChassis().getCountWheels();


        if (validator.isMovableCar(car)) {
            return "enough_wheels";
        }

        Map<String, ArrayList<String>> request = CommandProvider.userRequest;
        Object key = request.keySet().toArray()[0];

        List<String> requestData = request.get(key);

        String wheelDiameter = requestData.get(0);

        if (!validator.isValidDiameterWheel(wheelDiameter)) {
            return "invalid_wheel_diameter";
        }

        Wheel wheel = new Wheel(Integer.parseInt(wheelDiameter));
        car.getChassis().addWheel(String.valueOf(countWheels), wheel);

        List<String> listAllCar = dataReader.readDataFile();

        DataWriter writer = new DataWriter();
        writer.writeTempData(car);
        writer.writeData(listTempCar, listAllCar, car);

        return "wheel add " + car;
    }
}
