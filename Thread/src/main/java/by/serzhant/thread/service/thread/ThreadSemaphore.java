package by.serzhant.thread.service.thread;

import by.serzhant.thread.entity.Matrix;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

public class ThreadSemaphore implements Callable<String> {
    private Matrix matrix;
    private Semaphore semaphore;
    private int position;
    private int uniqueValue;

    public ThreadSemaphore(Semaphore semaphore, Matrix matrix, int position) {
        this.semaphore = semaphore;
        this.matrix = matrix;
        this.position = position;
        this.uniqueValue = new Random().nextInt(20) + 1;
    }

    @Override
    public String call() throws Exception {
        semaphore.acquire();

        matrix.changeElement(position, uniqueValue);

        semaphore.release();

        return "Done";
    }
}
