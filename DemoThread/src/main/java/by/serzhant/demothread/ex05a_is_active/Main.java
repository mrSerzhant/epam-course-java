package by.serzhant.demothread.ex05a_is_active;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()  + " поток начал свою работу");
        ThreadToDisable threadToDisable = new ThreadToDisable();
        Thread thread = new Thread(threadToDisable);
        thread.start();

        try{
            TimeUnit.SECONDS.sleep(10);

            threadToDisable.disable();

            TimeUnit.SECONDS.sleep(1);


        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()  + " поток завершил свою работу свою работу");
    }
}
