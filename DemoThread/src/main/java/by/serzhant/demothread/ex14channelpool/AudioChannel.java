package by.serzhant.demothread.ex14channelpool;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AudioChannel {
    private int channelID;

    public AudioChannel(int id){
        super();
        this.channelID = id;
    }

    public int getChannelID(){
        return channelID;
    }

    public void setChannelID(int id){
        this.channelID = id;
    }

    public void using(){
        try{
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(500));
        }catch (InterruptedException e){
            e.printStackTrace();
        }



    }
}
