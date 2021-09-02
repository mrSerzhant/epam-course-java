package by.serzhant.uml.entity;

import java.util.Map;
import java.util.Objects;

public class Chassis {
    private Map<String, Wheel> chassis;
    private int countWheels;

    public Chassis(Map<String, Wheel> chassisMap) {
        this.chassis = chassisMap;
        this.countWheels = chassisMap.size();
    }

    public int getCountWheels() {
        return countWheels;
    }

    public Map<String, Wheel> getChassis() {
        return chassis;
    }


    public void addWheel(String position, Wheel wheel) {

        chassis.put(position, wheel);


    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chassis chassis1 = (Chassis) o;
        return countWheels == chassis1.countWheels &&
                Objects.equals(chassis, chassis1.chassis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chassis, countWheels);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, Wheel> entry : chassis.entrySet()) {

            int numberWheel = Integer.parseInt(entry.getKey()) + 1;


            stringBuilder.append("number_wheel -").append(numberWheel).append(" : ").append(entry.getValue().toString());
        }

        return stringBuilder.toString();
    }
}
