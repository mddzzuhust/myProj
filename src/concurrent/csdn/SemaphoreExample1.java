package concurrent.csdn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample1 {

    private final static int threadCount = 20;

    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);

        for(int i=0;i<threadCount;i++){
            final int threadNum = i;
            exec.execute(() ->{
                try {
                    semaphore.tryAcquire(1, TimeUnit.SECONDS);
                    test(threadNum);
                    semaphore.release();
                }catch (Exception e){
                    System.out.println(e.toString());
                }
            });
        }
        exec.shutdown();
    }

    public static void test(int threadNum) throws Exception {
        System.out.println(threadNum);
        Thread.sleep(1000);
    }
}