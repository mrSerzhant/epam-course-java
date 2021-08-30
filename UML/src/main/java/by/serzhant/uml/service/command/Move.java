package by.serzhant.uml.service.command;

import by.serzhant.uml.entity.Car;

public class Move implements Command {
    private Car car;

    public Move(Car car){
        this.car = car;
    }

    @Override
    public Object execute() {
        return car.move();
    }
}
