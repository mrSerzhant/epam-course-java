package by.serzhant.uml.service.command;

import by.serzhant.uml.dal.DataReader;
import by.serzhant.uml.dal.DataWriter;
import by.serzhant.uml.dal.TempCarReader;
import by.serzhant.uml.entity.Car;
import by.serzhant.uml.service.util.DataParser;

import java.util.List;

public class Move implements Command {

    @Override
    public Object execute() {
        TempCarReader reader = new TempCarReader();
        List<String> stringList = reader.readDaoFile();

        DataParser dataParser = new DataParser();
        List<Car> listCar = dataParser.parse(stringList);

        if(listCar.isEmpty()){
            return "select_car";
        }


        Car car = listCar.get(0);
        String response = car.move();

        DataWriter writer = new DataWriter();
        writer.write(car);

        return response + " " + car;
    }
}
