package by.serzhant.demothread.ex14channelpool;


public class Client implements Runnable {
    private boolean reading = false;
    private ChannelPool<AudioChannel> pool;
    private int id;

    public Client(ChannelPool<AudioChannel> pool, int id) {
        this.pool = pool;
        this.id = id;
    }

    @Override
    public void run() {
        AudioChannel channel = null;

        try {
            channel = pool.getResource(500);
            reading = true;

            System.out.println("Channel Client #" + id
                    + " took channel #" + channel.getChannelID());
            channel.using();
        } catch (ResourceException e) {
            System.out.println("Client #" + id  + " lost ->" +
                    "Превышено время ожидания");
        }finally {
            if(channel != null){
                reading = false;
                System.out.println("Channel Client #" + id +" : "
                +channel.getChannelID() + " channel released" );
                pool.returnResource(channel);
            }
        }
    }

    public boolean isReading(){
        return reading;
    }

}
