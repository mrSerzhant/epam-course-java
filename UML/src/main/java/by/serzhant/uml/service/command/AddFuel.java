package by.serzhant.uml.service.command;

import by.serzhant.uml.entity.Car;
import by.serzhant.uml.entity.FuelTank;

import java.util.HashMap;
import java.util.Map;

public class AddFuel implements Command {
    private Car car;

    public AddFuel(Car car) {
        this.car = car;
    }

    @Override
    public Object execute() {
        double currentCapacity = car.getFuelTank().getCapacity();

        car.getFuelTank().setCapacity(currentCapacity + 50);

        Map<String, FuelTank> response = new HashMap<>();
        response.put("current_fuel_capacity", car.getFuelTank());

        return response;
    }
}
