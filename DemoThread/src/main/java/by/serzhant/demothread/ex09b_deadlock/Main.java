package by.serzhant.demothread.ex09b_deadlock;

public class Main {


    public static void main(String[] args) {
        InviteAction inviteAction1 = new InviteAction("first");
        InviteAction inviteAction2 = new InviteAction("second");

        new Thread(new Runnable() {
            @Override
            public void run() {
                inviteAction1.invite(inviteAction2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                inviteAction2.invite(inviteAction1);
            }
        }).start();

    }

}
