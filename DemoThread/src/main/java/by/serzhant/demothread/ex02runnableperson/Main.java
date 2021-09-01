package by.serzhant.demothread.ex02runnableperson;

public class Main {

    public static void main(String[] args) {
        RunnablePerson alice = new RunnablePerson("alice");
        RunnablePerson bob = new RunnablePerson("Bob");

        Thread threadBob = new Thread(bob, " thread BOB");
        Thread threadAlice = new Thread(alice, " thread alice");

        threadBob.start();
        threadAlice.start();

        //установка приоритета рекомендуется
        threadAlice.setPriority(10);
        threadBob.setPriority(2);

        try{

            //мейн не закончит свою работу пока два потока не выполнят свою работу

            threadAlice.join();
            threadBob.join();
        }catch (InterruptedException newE){
            newE.printStackTrace();
        }

        System.out.println(" main has finished");

        //ошибка, поток завершен
        threadAlice.start();



    }








}
