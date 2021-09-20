package by.serzhant.demothread.ex10b_reentrantreadwritelock;

public class PointThread implements Runnable{
    private PointManager pointManager;
    private boolean writeStatus;
    private Point point;

    public PointThread(PointManager pointManager, Point point, boolean writeStatus){
        this.pointManager = pointManager;
        this.point = point;
        this.writeStatus = writeStatus;
    }


    @Override
    public void run() {
        if(writeStatus){
            pointManager.randomChangePoint(point);
        }else {
            pointManager.length(point);
        }
    }
}
