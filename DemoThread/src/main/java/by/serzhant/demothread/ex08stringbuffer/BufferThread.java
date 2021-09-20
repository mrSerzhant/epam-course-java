package by.serzhant.demothread.ex08stringbuffer;

import java.util.concurrent.TimeUnit;

public class BufferThread implements Runnable {
    private int counter = 0;
    private StringBuffer stringBuffer = new StringBuffer();

    @Override
    public void run() {
        synchronized (stringBuffer) {
            while (counter++ < 3) {
                stringBuffer.append("A");
                System.out.print("> " + counter + " ");
                System.out.println(stringBuffer);

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public StringBuffer getStringBuffer() {
        return stringBuffer;
    }

    public int getCounter() {
        return counter;
    }
}

