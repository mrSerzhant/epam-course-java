package by.serzhant.demothread.ex06synccommonresource;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class CommonResource {
    private int resource = 1;

    synchronized void increment() {
        for (int i = 1; i < 5; i++) {
            System.out.printf("%s %d \n", Thread.currentThread().getName(), resource);

            resource++;

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonResource that = (CommonResource) o;
        return resource == that.resource;
    }

    @Override
    public int hashCode() {
        return Objects.hash(resource);
    }

    @Override
    public String toString() {
        return "CommonResource{" +
                "resource=" + resource +
                '}';
    }
}
