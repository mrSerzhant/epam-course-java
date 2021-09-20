package by.serzhant.demothread.ex08stringbuffer;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        BufferThread bufferThread = new BufferThread();
        Thread thread = new Thread(bufferThread);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int counter = bufferThread.getCounter();
            while(counter++ < 6) {

                System.out.print("< " + counter + " ");
                bufferThread.getStringBuffer().append("B");
                System.out.println(bufferThread.getStringBuffer());
            }
        }
    }

