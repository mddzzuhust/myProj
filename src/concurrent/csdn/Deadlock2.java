package concurrent.csdn;


/*
 * 发生了死锁。Thread1先获得resource1的lock，Thread2先获得resource2的lock。
 * 在Thread1还没有将resource1的lock交出时，又等着去获得resource2的lock（因为关于resource2的语句嵌套在关于resource1的语句中）；
 * 同样，在Thread2还没有将resource2的lock交出时，又等着去获得resource1的lock（因为关于resource1的语句嵌套在关于resource2的语句中）。
 * 因此陷入了Deadlock
 * */
public class Deadlock2 {
    public static void main(String[] args) {
        final String resources1 = "aaa";
        final String resources2 = "bbb";

        Thread t1 = new Thread() {
            public void run() {
                synchronized (resources1) {
                    System.out.println("Thread 1: locked resource 1");

                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }

                    synchronized (resources2){
                        System.out.println("Thread 1: locked resource 2");
                    }
                }
            }
        };

        Thread t2 = new Thread(){
            public void run(){
                synchronized (resources2){
                    System.out.println("Thread 2: locked resource 2");

                    try { Thread.sleep(100);} catch (Exception e) {}

                    synchronized (resources1){
                        System.out.println("Thread 2: locked resource 1");
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}