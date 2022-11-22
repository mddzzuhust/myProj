package concurrent;

import di.Student;

import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args){
        new TestCyclicBarrier().begin();
    }

    public void begin(){
        for (int i = 0; i < 5; i++) {
            new Thread(new Student()).start();
        }
    }

    private class Student implements Runnable{
        @Override
        public void run(){
            try {
                Thread.sleep(2000);
                cyclicBarrier.await();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
