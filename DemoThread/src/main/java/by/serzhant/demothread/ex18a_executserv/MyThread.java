package by.serzhant.demothread.ex18a_executserv;

public class MyThread implements Runnable{
    private int idTask;

    public MyThread(int idTask){
        this.idTask = idTask;
    }

    @Override
    public void run() {
        System.out.println("Выполнение потока: " + Thread.currentThread().getName() + " - Задача " + idTask);
    }
}
