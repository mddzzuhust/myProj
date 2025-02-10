import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadIncrement {

    // 使用 AtomicInteger 来保证线程安全
    private static AtomicInteger number = new AtomicInteger(0);

    public static void main(String[] args) {
        // 创建多个线程
        Thread thread1 = new Thread(new IncrementTask());
        Thread thread2 = new Thread(new IncrementTask());

        // 启动线程
        thread1.start();
        thread2.start();

        // 等待线程执行完毕
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 输出最终结果
        System.out.println("Final value: " + number.get());
    }

    // 任务类，用于执行加操作
    static class IncrementTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                number.incrementAndGet(); // 原子操作，线程安全
            }
        }
    }
}