package Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Process {

    static int counter = 0;

    public static void main(String[] args) {
        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);
        Runnable runnable = () -> {
            try {
                System.out.println("started task");
                Thread.sleep(200);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            if(counter++ ==3){
                throw new NumberFormatException("ds");
            }
            System.out.println("count = "+counter);
        };
        scheduler.scheduleAtFixedRate(runnable, 1,1, TimeUnit.MINUTES);
        System.out.println("finished");
    }
    
}
