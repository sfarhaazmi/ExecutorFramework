package threadpools;

public class TaskProcessor implements Runnable {

    private int task;
    public TaskProcessor(int task){
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ "[Task Inhand] task = "+(char)task);
        //doSomething(); //Business logic
       // System.out.println(Thread.currentThread().getName()+ "(DONE)[Task Completed] task = "+task);
    }

    private void doSomething() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
           System.out.println("Unable to perform the task: "+task);
        }
    }
}
