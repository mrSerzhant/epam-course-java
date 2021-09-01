package by.serzhant.demothread.ex01helloworld;

public class Main {

    public static void main(String[] args) {
        HelloWorldThread thread = new HelloWorldThread("Daughter thread");
        thread.setName("Hello World Thread");
        thread.start();

        HelloWorldThread thread1 = new HelloWorldThread();
        thread1.start();
        HelloWorldThread thread2 = new HelloWorldThread();
        thread2.start();

        System.out.println("State " + thread1.getState());
        System.out.println("State " + thread2.getState());


    }


}
