package concurrent.csdn;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runnabletest {
    public static void main(String[] args){
        Lock mylock = new ReentrantLock();
        Runnabletest runnabletest = new Runnabletest();
        mylock.lock();
        MyRunnable myRunnable = runnabletest.new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        mylock.unlock();
    }

    class MyRunnable implements Runnable{
        @Override
        public void run(){
            for(int i=0;i<100;i++){
                System.out.println(i);
            }
        }
    }
}