package by.serzhant.demothread.ex18a_executserv;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i = 0; i < 20; i++){
            executorService.execute(new Thread(new MyThread(i+1)));
        }

        executorService.shutdown();
    }
}
