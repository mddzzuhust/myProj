package concurrent.csdn;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample1 {
    private final static int threadCount = 200;

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount;i++){
            final int threadNum = i;
            exec.execute(() ->{
                try {
                    test(threadNum);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await(1000000000, TimeUnit.MILLISECONDS);
        System.out.println("finish");
        exec.shutdown();
    }

    public static void test(int threadNum) throws Exception {
        Thread.sleep(100);
        System.out.println(threadNum);
        Thread.sleep(100);
    }
}