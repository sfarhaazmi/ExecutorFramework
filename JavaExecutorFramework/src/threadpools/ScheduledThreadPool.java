package threadpools;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        try {
            for (int i = 1; i <= 3; i++) {
                Thread.sleep(2000);
                //scheduledExecutorService.schedule(new TaskProcessor(i), 3, TimeUnit.SECONDS); // schedule task delay to 3 seconds
                //scheduledExecutorService.scheduleAtFixedRate(new TaskProcessor(i), 2,5, TimeUnit.SECONDS);
                scheduledExecutorService.scheduleWithFixedDelay(new TaskProcessor(i), 5, 5, TimeUnit.SECONDS);
            }
            Thread.sleep(6000); // Adding some delay
            scheduledExecutorService.shutdown();
            System.out.println("Completed all threads");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
