package by.serzhant.demothread.ex03priority;

public class Main {

    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        System.out.println(t);

        Thread minPrior = new Thread(new PriorityThread("Min"));
        Thread normPrior = new Thread(new PriorityThread("Norm"));
        Thread maxPrior = new Thread(new PriorityThread("Max"));

        minPrior.setPriority(Thread.MIN_PRIORITY);
        normPrior.setPriority(Thread.NORM_PRIORITY);
        maxPrior.setPriority(Thread.MAX_PRIORITY);

        minPrior.start();
        normPrior.start();
        maxPrior.start();
    }
}
