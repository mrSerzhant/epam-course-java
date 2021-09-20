package by.serzhant.demothread.ex09b_deadlock;

public class InviteAction {
    private String name;

    public InviteAction(String name){
        this.name = name;
    }

    public synchronized void invite(InviteAction obj){
        System.out.println(name + " invites "+ obj.name);
        obj.action();
    }

    public synchronized void action(){
        System.out.println(name + " action");
    }

}
