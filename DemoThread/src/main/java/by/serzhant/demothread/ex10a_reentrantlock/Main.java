package by.serzhant.demothread.ex10a_reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource();
        ReentrantLock locker = new ReentrantLock();
        for (int i = 1; i < 6; i++) {

            Thread thread = new Thread(new CountThread(commonResource, locker));
            thread.setName("Поток " + i);
            thread.start();
        }
    }
}
