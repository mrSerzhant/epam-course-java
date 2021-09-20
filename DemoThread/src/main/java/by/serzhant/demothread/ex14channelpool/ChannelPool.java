package by.serzhant.demothread.ex14channelpool;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ChannelPool<T> {
    private final static int POOL_SIZE = 5;
    private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
    private final Queue<T> resource = new LinkedList<>();

    public ChannelPool(Queue<T> source) {
        resource.addAll(source);
    }

    public T getResource(long maxWaitMillis) throws ResourceException {
        try {
            if (semaphore.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)) {
                T res = resource.poll();
                return res;
            }
        }catch (InterruptedException e){
            throw new ResourceException();
        }
        throw new ResourceException();
    }

    public void returnResource(T res){
        resource.add(res);
        semaphore.release();
    }
}
