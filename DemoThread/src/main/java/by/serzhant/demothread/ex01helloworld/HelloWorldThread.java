package by.serzhant.demothread.ex01helloworld;

public class HelloWorldThread extends Thread {

    HelloWorldThread(){
        super();
    }

    HelloWorldThread(String name){
        super(name);
    }

    public void run(){
        System.out.println(getName()  + " Thread message - Hello World");
    }

}
