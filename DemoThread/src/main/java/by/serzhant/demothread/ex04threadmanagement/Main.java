package by.serzhant.demothread.ex04threadmanagement;

public class Main {

    public static void main(String[] args) {
        System.out.println("Старт потока main + " + Thread.currentThread().getName());

        Thread joinThread1 = new Thread(new JoinThread("First"));
        Thread joinThread2 = new Thread(new JoinThread("Second"));
        joinThread1.start();
        joinThread2.start();

        try{
            joinThread1.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Завершение потока "+ Thread.currentThread().getName());
    }
}
