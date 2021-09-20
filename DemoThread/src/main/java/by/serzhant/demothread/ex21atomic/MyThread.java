package by.serzhant.demothread.ex21atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread implements Runnable{
    private AtomicInteger atomic;

    public MyThread(AtomicInteger atomic){
        this.atomic = atomic;
    }

    @Override
    public void run() {
        for(int i = 0; i < 50000; i++){
            atomic.incrementAndGet();
        }
    }
}
