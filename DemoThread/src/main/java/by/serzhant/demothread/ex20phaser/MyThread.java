package by.serzhant.demothread.ex20phaser;

import java.util.concurrent.Phaser;

public class MyThread implements Runnable{
    private Phaser phaser;

    public MyThread(Phaser phaser){
        this.phaser = phaser;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "Выполнил фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();

        System.out.println(Thread.currentThread().getName() + "Выполнил фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();

        System.out.println(Thread.currentThread().getName() + "Выполнил фазу " + phaser.getPhase());
        phaser.arriveAndDeregister();

    }
}
