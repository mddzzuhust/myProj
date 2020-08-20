package concurrent.TwowanZiJavaConcurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePriorities implements Runnable{

    private int priority;

    public SimplePriorities(int priority){
        this.priority = priority;
    }

    @Override
    public void run(){
        Thread.currentThread().setPriority(priority);
        for (int i = 0; i < 100; i++) {
            System.out.println(this);
            if(i%10==0){
                Thread.yield();
            }
        }
    }

    @Override
    public String toString(){
        return Thread.currentThread() + " " + priority;
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            service.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        }
        service.execute(new SimplePriorities(Thread.MIN_PRIORITY));
    }
}
