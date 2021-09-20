package by.serzhant.demothread.ex16barrier;

import java.util.Random;

public class AuctionRunner {
    public static void main(String[] args) {
        Auction auction = new Auction();
        int startPrice = new Random().nextInt(100);

        for (int i = 0; i < auction.BIDS_NUMBER; i++) {
            Bid threadBid = new Bid(i, startPrice, auction.getBarrier());
            auction.add(threadBid);

            Thread thread = new Thread(threadBid);
            thread.start();
        }
    }
}
