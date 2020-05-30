package concurrent.csdn;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample1 {
    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) throws Exception{
        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i=0;i<15;i++){
            final int threadNum = i;
            Thread.sleep(1000);
            executor.execute(() ->{
                try {
                    race(threadNum);
                }catch (Exception e){
                    System.out.println(e.toString());
                }
            });
        }
    }

    private static void race(int threadNum) throws Exception{
        Thread.sleep(1000);
        System.out.println(threadNum);
        barrier.await();
    }
}