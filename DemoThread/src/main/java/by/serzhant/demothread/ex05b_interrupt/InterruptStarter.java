package by.serzhant.demothread.ex05b_interrupt;

import java.util.concurrent.TimeUnit;

public class InterruptStarter {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()  + " поток начал свою работу");
        ThreadInterrupt threadInterrupt = new ThreadInterrupt();
        Thread thread = new Thread(threadInterrupt);
        thread.start();

        try{
            TimeUnit.SECONDS.sleep(5);

            thread.interrupt();

            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            System.out.println("Поток был прерван");
        }

        System.out.println(Thread.currentThread().getName()  + " поток завершил свою работу свою работу");
    }

}
