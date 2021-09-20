package by.serzhant.demothread.ex16barrier;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Bid implements Runnable{
    private Integer bidId;
    private int price;
    private CyclicBarrier barrier;

    public Bid(int id, int price, CyclicBarrier barrier){
        this.bidId = id;
        this.price = price;
        this.barrier = barrier;
    }

    public Integer getBidId(){
        return bidId;
    }

    public int getPrice(){
        return  price;
    }


    @Override
    public void run() {

        try{

            System.out.println("Client " + this.bidId + " specifies a price.");
            TimeUnit.SECONDS.sleep(3);
            int delta = new Random().nextInt(50);
            price += delta;
            System.out.println("Bid " + this.bidId + " : " + price);
            this.barrier.await();
            System.out.println("Continue to work...");
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
