package by.serzhant.demothread.ex09threadProducer;

public class Store {
    private int counter = 0;
    private final int STORE_SIZE = 5;

    synchronized int put() {
        if(counter < STORE_SIZE ) {
            counter++;
            System.out.println ("склад имеет " + counter + " товар(ов)");
            return 1;
        }
        return 0;
    }

    synchronized int get() {
        if(counter > 0) {
            counter--;
            System.out.println ("склад имеет " + counter + " товар(ов)");
            return 1;
        }
        return 0;
    }
}
