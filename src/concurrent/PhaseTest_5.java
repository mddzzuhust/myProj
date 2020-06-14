package concurrent;

import java.util.concurrent.Phaser;

public class PhaseTest_5 {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);

        //五个子任务
        for (int i = 0; i < 3; i++) {
            Task_05 task = new Task_05(phaser);
            Thread thread = new Thread(task,"PhaseTest_"+i);
            thread.start();
        }

        try {
            //等待3秒
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        phaser.arrive(); //countDownLatch.countDown()
    }

    static class Task_05 implements Runnable{
        private final Phaser phaser;

        Task_05(Phaser phaser){
            this.phaser = phaser;
        }

        @Override
        public void run(){
            phaser.awaitAdvance(phaser.getPhase()); //countDownLatch.await()
            System.out.println(Thread.currentThread().getName() + "执行任务...");
        }
    }
}

//在这里，任务一开始并没有真正执行，而是等待三秒后执行。
//
//对于CyclicBarrier就更加简单了，直接arriveAndAwaitAdvance()方法替换，如example 1。
