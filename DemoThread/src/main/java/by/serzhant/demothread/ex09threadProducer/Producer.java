package by.serzhant.demothread.ex09threadProducer;

import java.util.concurrent.TimeUnit;

public class Producer implements Runnable{
    private Store store;
    private int product = 5;

    public Producer(Store store){
        this.store = store;
    }

    @Override
    public void run() {
        try {
            while (product > 0) {
                product = product - store.put();
                System.out.println("производителю осталось произвести " + product + " товар(ов)");
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            System.out.println("поток производителя прерван");
        }
    }

    public Store getStore() {
        return store;
    }

    public int getProduct() {
        return product;
    }
}
