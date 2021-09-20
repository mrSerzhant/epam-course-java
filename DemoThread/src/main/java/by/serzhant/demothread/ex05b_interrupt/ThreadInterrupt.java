package by.serzhant.demothread.ex05b_interrupt;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt implements Runnable{

    @Override
    public void run() {
        System.out.println(String.format("Поток %s начал свою работу", Thread.currentThread().getName()));

        int counter = 1;

        while(!Thread.currentThread().isInterrupted()){
            System.out.println("Цикл " + counter++);

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().isInterrupted());

                Thread.currentThread().interrupt();

            }
        }

        System.out.println(String.format("Поток %s завершил свою работу", Thread.currentThread().getName()));
    }
}
