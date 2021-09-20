package by.serzhant.demothread.ex05a_is_active;

import java.util.concurrent.TimeUnit;

public class ThreadToDisable implements Runnable {
    private boolean isActive;

    public ThreadToDisable(){
        isActive = true;
    }

    public void disable(){
        isActive = false;
    }

    @Override
    public void run() {
        System.out.println(String.format("Поток %s начал свою работу", Thread.currentThread().getName()));

        int counter = 1;

        while(isActive){
            System.out.println("Цикл " + counter++);

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(String.format("Поток %s завершил свою работу", Thread.currentThread().getName()));
    }
}
