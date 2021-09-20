package by.serzhant.demothread.ex21atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        AtomicInteger atomic = new AtomicInteger(0);

        Thread t = new Thread(new MyThread(atomic));
        Thread t2 = new Thread(new MyThread(atomic));
        t.start();
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(atomic);
    }
}
