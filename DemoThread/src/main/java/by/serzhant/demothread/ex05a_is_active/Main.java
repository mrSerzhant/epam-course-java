package by.serzhant.demothread.ex05a_is_active;


public class Main {

    public static void main(String[] args) {

        ThreadToDisable threadToDisable = new ThreadToDisable();

        Thread myT = new Thread(threadToDisable, "d");


        myT.start();


    }





}
