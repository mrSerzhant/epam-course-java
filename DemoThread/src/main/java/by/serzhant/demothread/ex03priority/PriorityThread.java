package by.serzhant.demothread.ex03priority;

import java.util.concurrent.TimeUnit;

public class PriorityThread implements Runnable {
    private String name;

    public PriorityThread(String name){
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(name + " " + i);
          /*  try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.err.print(e.getMessage());
            } */
        }

    }
}
