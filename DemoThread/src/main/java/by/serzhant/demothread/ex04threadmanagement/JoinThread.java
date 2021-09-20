package by.serzhant.demothread.ex04threadmanagement;

public class JoinThread implements Runnable {
    private String name;

    public JoinThread(String name) {
        this.name = name;
    }

    public void run() {
        String nameT = name;
        long timeout = 0;
        System.out.println("Старт потока " + nameT);

        try {
            switch (nameT) {
                case "First":
                    timeout = 5_000;
                    break;
                case "Second":
                    timeout = 1_000;
                    break;
            }
            Thread.sleep(timeout);
            System.out.println("Завершение потока " + nameT);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
