package by.serzhant.demothread.ex17cdl;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class MyThread implements Runnable{
    private int id;
    private CountDownLatch countDownLatch;
    private int[] array;

    public MyThread(CountDownLatch countDownLatch, int id, int[] array){
        this.countDownLatch = countDownLatch;
        this.id = id;
        this.array = array;

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "начинает выполенение");

        array[id] = new Random().nextInt(10);

        countDownLatch.countDown();

        int result = 0;

        for(Integer e : array){
            result = e + result;
        }

        System.out.println(result);
    }
}
