package by.serzhant.demothread.ex05c_demon;

import java.util.concurrent.TimeUnit;

public class DemonThreadRunner {
    public static void main(String[] args) {
        DemonThread demonThread = new DemonThread();
        Thread thread = new Thread(demonThread);
        thread.setDaemon(true);
        //main поток завершит бесконечный цикл потока-демона
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {

        }

        System.out.println(Thread.currentThread().getName()  + " поток завершил свою работу свою работу");
    }
}
