package by.serzhant.thread.service.thread;

import by.serzhant.thread.entity.Matrix;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadReentrantLock implements Callable<String> {
    private Matrix matrix;
    private ReentrantLock locker;
    private int position;
    private int uniqueValue;

    public ThreadReentrantLock(ReentrantLock locker, Matrix matrix, int position){
        this.locker = locker;
        this.matrix = matrix;
        this.position = position;
        this.uniqueValue = new Random().nextInt(20)+1;
    }

    @Override
    public String call() {
        locker.lock();

        try {
            matrix.changeElement(position, uniqueValue);
        } finally {
            locker.unlock();
        }

        return "Done";
    }
}
