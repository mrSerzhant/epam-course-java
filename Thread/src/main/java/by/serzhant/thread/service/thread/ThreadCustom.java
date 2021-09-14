package by.serzhant.thread.service.thread;

import by.serzhant.thread.entity.Matrix;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ThreadCustom implements Callable<String> {
    private Matrix matrix;
    private int position;
    private int uniqueValue;

    public ThreadCustom(Matrix matrix, int position){
        this.matrix = matrix;
        this.position = position;
        this.uniqueValue = new Random().nextInt(20)+1;
    }

    @Override
    public String call() throws Exception {
        if (position != 0) {

            while (matrix.getElement(position-1) == 0) {
                TimeUnit.SECONDS.sleep(1);
            }
        }

        matrix.changeElement(position, uniqueValue);
        return "done";
    }
}
