package by.serzhant.uml.dal;

import by.serzhant.uml.entity.Car;
import by.serzhant.uml.entity.typecar.Sedan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;

public class DataWriter {
    private static final Logger LOGGER = LogManager.getLogger(DataWriter.class);
    private static final String DAO_PATH = "./UML/src/main/resources/data/TempCar";

    public void write(Car inputCar) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(inputCar.getType()).append(" ");

        if (inputCar instanceof Sedan) {
            stringBuilder.append(((Sedan) inputCar).getBrand()).append(" ");
        }

        stringBuilder.append(inputCar.getEngine().getBrand()).append(" ");
        stringBuilder.append(inputCar.getEngine().getPower()).append(" ");

        stringBuilder.append(inputCar.getChassis().getCountWheels()).append(" ");
        stringBuilder.append(inputCar.getChassis().getChassis().get("1").getDiameter()).append(" ");
        stringBuilder.append(inputCar.getFuelTank().getCapacity()).append(" ");

        try (FileWriter writer = new FileWriter(DAO_PATH)) {
            writer.write(stringBuilder.toString());
            writer.flush();
            LOGGER.info("Успешная запись в файл");
        } catch (IOException ex) {
            LOGGER.error("Ошибка записи в файл");
        }
    }
}
