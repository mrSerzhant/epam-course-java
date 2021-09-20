package by.serzhant.demothread.ex01helloworld;

public class Main {

    public static void main(String[] args) {
        HelloWorldThread thread = new HelloWorldThread("New thread");
        thread.start();
    }
}
