package by.serzhant.demothread.ex02runnableperson;

import java.util.concurrent.TimeUnit;

public class RunnablePerson extends Person implements Runnable {
    public void run() {


        for(int i = 0; i < 100; i++){

            System.out.println(i + getSurname());


            try{
                //Thread.sleep(10);

                TimeUnit.MILLISECONDS.sleep(10);
            }catch (InterruptedException newE){

                newE.printStackTrace();

            }



        }



    }
}
