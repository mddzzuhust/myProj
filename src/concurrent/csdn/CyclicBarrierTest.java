package concurrent.csdn;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
//从结果可以看出：MainTask任务在一组中的5个任务执行完后才开始执行。
public class CyclicBarrierTest {
    public static void main(String[] args) {
//创建CyclicBarrier对象，
//并设置执行完一组5个线程的并发任务后，再执行MainTask任务
        CyclicBarrier cb = new CyclicBarrier(2,new MainTask());
        new SubTask("A",cb).start();
        new SubTask("B",cb).start();
        new SubTask("C",cb).start();
        new SubTask("D",cb).start();
        new SubTask("E",cb).start();
//new SubTask("F",cb).start();

    }
}
/**
 * 最后执行的任务
 */
class MainTask implements Runnable{
    public void run(){
        System.out.println("......终于要执行最后的任务了......");
    }
}
/**
 * 一组并发任务
 */
class SubTask extends Thread{
    private String name;
    private CyclicBarrier cb;

    SubTask(String name,CyclicBarrier cb){
        this.name = name;
        this.cb = cb;
    }

    public void run(){
        System.out.println("[并发任务"+name+"]开始执行");
        for (int i = 0; i < 999999; i++) {

        }

        System.out.println("[并发任务"+name+"]开始执行完毕，通知障碍器");
        try {
            cb.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (BrokenBarrierException e){
            e.printStackTrace();
        }
    }
}