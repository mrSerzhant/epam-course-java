package by.serzhant.thread.service.command;

import by.serzhant.thread.dal.DataReader;
import by.serzhant.thread.entity.Matrix;
import by.serzhant.thread.service.thread.ThreadCountDownLatch;
import by.serzhant.thread.service.parser.Parser;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CountDownLatchExample implements Command {
    @Override
    public Object execute() {
        DataReader reader = new DataReader();
        Parser parser = new Parser();

        Integer[][] tempMatrix = parser.parseTempMatrixElement(reader.readMatrixTempDataFile());
        int countThread = Integer.parseInt(reader.readThreadTempDataFile().get(0));

        Matrix matrix = new Matrix(tempMatrix);

        ExecutorService service = Executors.newFixedThreadPool(countThread);
        CountDownLatch countDownLatch = new CountDownLatch(matrix.getRowLength());

        for (int i = 0; i < matrix.getRowLength(); i++) {
            service.execute(new ThreadCountDownLatch(countDownLatch, matrix, i));
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.shutdown();

        return matrix;
    }
}
