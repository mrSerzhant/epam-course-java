package by.serzhant.demothread.ex09threadProducer;

import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private Store store;
    private int product = 0;
    private int N = 5;

    public Consumer(Store store){
        this.store = store;
    }

    @Override
    public void run() {
        try {
            while (product < N) {
                product = product + store.get();
                System.out.println("Потребитель купил " + product + " товар(ов)");
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            System.out.println("поток потребителя прерван");
        }

    }
}
