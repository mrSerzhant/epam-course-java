package by.serzhant.demothread.ex10a_reentrantlock;

public class CommonResource {
    private int resource = 0;

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
}
