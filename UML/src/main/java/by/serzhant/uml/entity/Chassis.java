package by.serzhant.uml.entity;

import java.util.HashMap;
import java.util.Map;

public class Chassis {
    private Map<String, Wheel> chassis;
    private int numberOfWheel;

    public Chassis(int numberOfWheel) {
        this.numberOfWheel = numberOfWheel;
        this.chassis = new HashMap<>(numberOfWheel);

    }






 //   private void setWheel(String position,){}


}
