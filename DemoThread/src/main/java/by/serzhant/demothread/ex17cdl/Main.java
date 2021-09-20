package by.serzhant.demothread.ex17cdl;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[5];
        CountDownLatch countDownLatch = new CountDownLatch(5);

       for (int i = 0; i < 5; i++) {
            new Thread(new MyThread(countDownLatch, i, array)).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
