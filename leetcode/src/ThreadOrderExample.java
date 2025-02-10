public class ThreadOrderExample {

    public static void main(String[] args) {
        // 创建线程2
        Thread thread2 = new Thread(() -> {
            System.out.println("线程2开始执行");
            try {
                Thread.sleep(1000); // 模拟线程2执行一些任务
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2执行完毕");
        });

        // 创建线程1
        Thread thread1 = new Thread(() -> {
            System.out.println("线程1开始执行");
            try {
                Thread.sleep(500); // 模拟线程1执行一些任务
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程1执行完毕");
        });

        // 启动线程2
        thread2.start();

        try {
            // 主线程等待线程2执行完毕
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 启动线程1
        thread1.start();

        try {
            // 主线程等待线程1执行完毕
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("所有线程执行完毕");
    }
}
