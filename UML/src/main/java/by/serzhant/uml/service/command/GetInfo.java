package by.serzhant.uml.service.command;

import by.serzhant.uml.entity.Car;

public class GetInfo implements Command {
    private Car car;

    public GetInfo(Car car){
        this.car = car;
    }


    @Override
    public Object execute() {
        return null;
    }
}
