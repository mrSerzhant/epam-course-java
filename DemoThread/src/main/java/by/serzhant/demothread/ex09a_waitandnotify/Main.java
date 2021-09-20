package by.serzhant.demothread.ex09a_waitandnotify;

public class Main {

    public static void main(String[] args) {
        Store store = new Store();
        Consumer consumer = new Consumer(store);
        Producer producer = new Producer(store);

        Thread thread = new Thread(consumer);
        Thread thread2 = new Thread(producer);

        thread.start();
        thread2.start();
    }
}
