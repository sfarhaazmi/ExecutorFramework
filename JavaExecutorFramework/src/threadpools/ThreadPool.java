package threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) {

        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Core Count: "+coreCount);
        //ExecutorService executor = Executors.newSingleThreadExecutor();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for(char i='a'; i<='z'; i++){
            executor.execute(new TaskProcessor(i));
        }

        executor.shutdown(); // rejects any new tasks from being accepted and gracefully shuts down the service
        executor.execute(new TaskProcessor('i'));
        //executor.shutdownNow(); //Immediately shuts down executor service
        System.out.println("Is shutdown? "+executor.isShutdown());
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
//OR
        while(!(executor.isTerminated())){

        }

        System.out.println("Submitted all tasks");

    }
}