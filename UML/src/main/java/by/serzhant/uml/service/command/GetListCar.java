package by.serzhant.uml.service.command;

import by.serzhant.uml.dal.DataReader;
import by.serzhant.uml.entity.Car;
import by.serzhant.uml.service.exception.ExecuteException;
import by.serzhant.uml.service.util.DataParser;

import java.util.List;

public class GetListCar implements Command {

    @Override
    public Object execute() throws ExecuteException {
        DataReader reader = new DataReader();
        List<String> stringList = reader.readDataFile();

        DataParser dataParser = new DataParser();
        List<Car> listCar = dataParser.parse(stringList);

        if(listCar.isEmpty()){
            return "list_is_empty";
        }

        return listCar;
    }
}
