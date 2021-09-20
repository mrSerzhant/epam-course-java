package by.serzhant.demothread.ex18b_callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<MyThread> listThread = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i = 0; i < 20; i++){

            listThread.add(new MyThread(i+1));

        }

        List<Future<Integer>> futures = null;

        try {
             futures = executorService.invokeAll(listThread);
        }catch (Exception e){
            System.out.println("Ошибка");
        }

        for(Future<Integer> el : futures){
            System.out.println(el.get());
        }
    }

}
