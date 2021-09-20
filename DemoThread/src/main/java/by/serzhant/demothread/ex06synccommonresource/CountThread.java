package by.serzhant.demothread.ex06synccommonresource;

public class CountThread implements Runnable{
    private CommonResource commonResource;

    public CountThread(CommonResource commonResource){
        this.commonResource = commonResource;
    }


    @Override
    public void run() {

       commonResource.increment();

    }
}
