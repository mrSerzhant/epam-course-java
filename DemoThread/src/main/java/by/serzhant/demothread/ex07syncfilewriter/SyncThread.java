package by.serzhant.demothread.ex07syncfilewriter;

public class SyncThread implements Runnable{
    private Resource resource;

    public SyncThread(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            resource.writing(Thread.currentThread().getName(), i);
        }
    }
}
