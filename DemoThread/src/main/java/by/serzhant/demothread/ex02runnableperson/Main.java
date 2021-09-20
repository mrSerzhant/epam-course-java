package by.serzhant.demothread.ex02runnableperson;

public class Main {

    public static void main(String[] args) {
      RunnablePerson person1 = new RunnablePerson("Alice");
      Thread aliceThread = new Thread(person1);
      aliceThread.start();
      RunnablePerson person2 = new RunnablePerson("Bob");
      Thread bobThread = new Thread(person2);
      bobThread.start();

    }








}
