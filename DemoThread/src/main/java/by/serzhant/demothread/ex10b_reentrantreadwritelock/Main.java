package by.serzhant.demothread.ex10b_reentrantreadwritelock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        PointManager pointManager = new PointManager();
        Random random = new Random();
        ExecutorService service = Executors.newFixedThreadPool(15);
        Point point = new Point(1, -1);

        for(int i = 0; i < 15; i++){
            service.submit(new PointThread(pointManager, point, random.nextBoolean()));
        }
        service.shutdown();
    }
}
