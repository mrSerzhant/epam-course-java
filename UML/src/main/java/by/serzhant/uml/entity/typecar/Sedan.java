package by.serzhant.uml.entity.typecar;

import by.serzhant.uml.entity.Car;
import by.serzhant.uml.entity.Chassis;
import by.serzhant.uml.entity.Engine;
import by.serzhant.uml.entity.FuelTank;

public class Sedan extends Car {
    private String brand;

    public Sedan(String brand, Engine engine, Chassis chassis, FuelTank fuelTank){
        super("sedan", engine, chassis, fuelTank);
        this.brand = brand;
    }



}
