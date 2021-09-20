package by.serzhant.demothread.ex10a_reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class CountThread implements Runnable {
    private CommonResource resource;
    private ReentrantLock locker;

    CountThread(CommonResource resource, ReentrantLock locker) {
        this.resource = resource;
        this.locker = locker;
    }

    @Override
    public void run() {
        locker.lock();
        try {
            resource.setResource(1);
            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), resource.getResource());

                int value = resource.getResource();
                resource.setResource(++value);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }
}
