package concurrent.csdn;

public class Threadtest {
    Integer lock = new Integer(1);
    public static void main(String[] args){
        Threadtest threadtest = new Threadtest();

        myThread myThread1=threadtest.new myThread();
        myThread myThread2=threadtest.new myThread();

        myThread2.start();
        myThread1.start();
    }

    class myThread extends Thread {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    System.out.print(i+" ");
                }
                System.out.println();
            }
        }
    }
}