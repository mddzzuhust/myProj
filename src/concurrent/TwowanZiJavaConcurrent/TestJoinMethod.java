package concurrent.TwowanZiJavaConcurrent;

import java.util.concurrent.TimeUnit;

public class TestJoinMethod extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            }catch (InterruptedException e){
                System.out.println("Interrupted sleep");
            }
            System.out.println(Thread.currentThread()+" "+i);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        TestJoinMethod join1 = new TestJoinMethod();
        TestJoinMethod join2 = new TestJoinMethod();
        TestJoinMethod join3 = new TestJoinMethod();

        join1.start();
        //join1.join();
        join2.start();
        join3.start();
    }
}
