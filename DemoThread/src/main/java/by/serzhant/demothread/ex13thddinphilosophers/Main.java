package by.serzhant.demothread.ex13thddinphilosophers;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore= new Semaphore(5);
        for (int i = 1; i <= 13; i++)
           new Thread(new Philosopher(semaphore,i)).start();
    }
}



