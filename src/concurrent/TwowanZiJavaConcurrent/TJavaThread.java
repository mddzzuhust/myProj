package concurrent.TwowanZiJavaConcurrent;

public class TJavaThread extends Thread {
    static int count;

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TJavaThread tJavaThread = new TJavaThread();
        tJavaThread.start();
        tJavaThread.join();
        System.out.println("count = " + count);
    }
}
