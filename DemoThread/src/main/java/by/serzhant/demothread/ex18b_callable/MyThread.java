package by.serzhant.demothread.ex18b_callable;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<Integer> {
    private int idTask;

    public MyThread(int idTask){
        this.idTask = idTask;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Выполнение потока: " + Thread.currentThread().getName() + " - Задача " + idTask);

        return new Random().nextInt(10) * idTask;
    }
}
