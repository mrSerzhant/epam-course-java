package by.serzhant.demothread.ex06synccommonresource;

public class Main {

    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource();

        Thread thread = new Thread(new CountThread(commonResource));
        Thread thread2 = new Thread(new CountThread(commonResource));
        Thread thread3 = new Thread(new CountThread(commonResource));
        Thread thread4 = new Thread(new CountThread(commonResource));
        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
