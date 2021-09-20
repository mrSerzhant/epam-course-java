package by.serzhant.demothread.ex05c_demon;

import java.util.concurrent.TimeUnit;

public class DemonThread implements Runnable {

    @Override
    public void run() {
        int count = 0;

        while (true) {
            System.out.println(count++);

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
            }
        }
    }
}