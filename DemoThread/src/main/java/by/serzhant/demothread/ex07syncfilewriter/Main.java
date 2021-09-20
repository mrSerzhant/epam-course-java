package by.serzhant.demothread.ex07syncfilewriter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Resource resource = null;
        try {
            resource = new Resource ("./DemoThread/result.txt");

            SyncThread syncThread1 = new SyncThread(resource);
            SyncThread syncThread2 = new SyncThread(resource);

            Thread t1 = new Thread(syncThread1,"First");
            Thread t2 = new Thread(syncThread1,"Second");

            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (IOException e) {
            System.err.print("ошибка файла: " + e);
        } catch (InterruptedException e) {
            System.err.print("ошибка потока: " + e);
        } finally {
            resource.close();
        }
    }


}
