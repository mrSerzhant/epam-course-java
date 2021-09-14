package by.serzhant.thread.service.thread;

import by.serzhant.thread.entity.Matrix;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class ThreadCountDownLatch implements Runnable {
    private Matrix matrix;
    private CountDownLatch countDownLatch;
    private int position;
    private int uniqueValue;

    public ThreadCountDownLatch(CountDownLatch countDownLatch, Matrix matrix, int position) {
        this.matrix = matrix;
        this.countDownLatch = countDownLatch;
        this.position = position;
        this.uniqueValue = new Random().nextInt(20)+1;

    }

    @Override
    public void run() {
        matrix.changeElement(position, uniqueValue);
        countDownLatch.countDown();
    }
}
