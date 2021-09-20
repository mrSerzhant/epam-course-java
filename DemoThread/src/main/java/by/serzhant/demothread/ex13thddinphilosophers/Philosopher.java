package by.serzhant.demothread.ex13thddinphilosophers;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable{
    private Semaphore semaphore;
    private int num;
    private int id;

    public Philosopher(Semaphore semaphore, int id){
        this.semaphore = semaphore;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (num < 3){
                semaphore.acquire();
                System.out.println("Философ " + id + " садится за стол");
                TimeUnit.SECONDS.sleep(5);
                num++;
                System.out.println("Философ " + id + " выходит из-за стола");
                semaphore.release();
                TimeUnit.SECONDS.sleep(5);
            }
        } catch (InterruptedException e) {
            System.out.println("у философа " + id + " проблемы со здоровьем");
        }
    }
}
