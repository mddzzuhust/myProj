package concurrent.TwowanZiJavaConcurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThread extends Thread{

    @Override
    public synchronized void run() {
        int count = 0;
        for (int i = 0; i < 10000; i++) {
            count++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
//        ExecutorService service = Executors.newCachedThreadPool();
//        for (int i = 0; i < 5; i++) {
//            service.execute(new TestThread());
//        }
//        service.shutdown();

        ExecutorService service = Executors.newFixedThreadPool(5);
        for(int i = 0;i < 5;i++){
            service.execute(new TestThread());
        }
        service.shutdown();

//        ExecutorService service = Executors.newSingleThreadExecutor();
//        for(int i = 0;i < 5;i++){
//            service.execute(new TestThread());
//        }
//        service.shutdown();
    }
}
