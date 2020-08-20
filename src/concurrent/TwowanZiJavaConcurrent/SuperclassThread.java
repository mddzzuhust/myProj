package concurrent.TwowanZiJavaConcurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SuperclassThread extends TestThread {
    @Override
    public void run(){
        System.out.println(Thread.currentThread() + "starting ...");

        try {
            for (int i = 0; i < 5; i++) {
                if(i==3){
                    System.out.println(Thread.currentThread()+"sleeping...");
                    TimeUnit.MILLISECONDS.sleep(1000);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread()+"wakeup and end ...");
    }

    public static void main(String[] args) {
        ExecutorService executors = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executors.execute(new SuperclassThread());
        }
        executors.shutdown();
    }
}
