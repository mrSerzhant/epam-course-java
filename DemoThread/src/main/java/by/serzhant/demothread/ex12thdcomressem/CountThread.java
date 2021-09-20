package by.serzhant.demothread.ex12thdcomressem;

import java.util.concurrent.Semaphore;

public class CountThread implements Runnable {
    private CommonResource resource;
    private Semaphore semaphore;
    private String name;

    public CountThread(CommonResource resource, Semaphore semaphore, String name) {
        this.resource = resource;
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " ожидает разрешение");
            semaphore.acquire();
            resource.setX(1);
            for (int i = 1; i < 5; i++) {
                System.out.println(this.name + ": " + resource.getX());
                int value = resource.getX();
                resource.setX(++value);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(name + " освобождает разрешение");
        semaphore.release();

    }
}
