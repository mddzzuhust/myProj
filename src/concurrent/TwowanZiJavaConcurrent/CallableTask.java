package concurrent.TwowanZiJavaConcurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTask implements Callable {

    static int count;

    public CallableTask(int count) {
        this.count = count;
    }

    @Override
    public Object call() {
        return count;
    }

    public static void main(String[] args)
            throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask((Callable<Integer>) () -> {
            for (int i = 0; i < 1000; i++) {
                count++;
            }
            return count;
        });

        Thread thread = new Thread(task);
        thread.start();

        Integer total = task.get();
        System.out.println("total = " + total);
    }
}
