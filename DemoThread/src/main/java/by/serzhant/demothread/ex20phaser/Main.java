package by.serzhant.demothread.ex20phaser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class Main {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(4);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i = 0; i < 3; i++){
            executorService.execute(new MyThread(phaser));
        }

        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phaser.getPhase() + "завершена");

        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phaser.getPhase() + "завершена");

        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phaser.getPhase() + "завершена");

        phaser.arriveAndDeregister();
    }
}
