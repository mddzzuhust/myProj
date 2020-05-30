package concurrent.csdn;

public class Deadlock2resovle {
    public static void main(String[] args) {
        final String resources1 = "aaa";
        final String resources2 = "bbb";

        Thread t1 = new Thread() {
            public void run() {
                synchronized (resources1) {
                    System.out.println("Thread 1: locked resource 1");
                }
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }

                synchronized (resources2){
                    System.out.println("Thread 1: locked resource 2");
                }

            }
        };

        Thread t2 = new Thread(){
            public void run(){
                synchronized (resources2) {
                    System.out.println("Thread 2: locked resource 2");
                }
                try { Thread.sleep(100);} catch (Exception e) {}

                synchronized (resources1){
                    System.out.println("Thread 2: locked resource 1");
                }
            }
        };

        t1.start();
        t2.start();
    }
}