package leetcode;

import java.util.concurrent.Semaphore;

public class H2O {
    private Semaphore s1,s2,s3,s4;

    public H2O() {
        s1 = new Semaphore(2);
        s2 = new Semaphore(1);

        s3 = new Semaphore(0);
        s4 = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        s1.acquire();
        s3.release();
        s4.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        s1.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        s2.acquire();
        s4.release(2);
        s3.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        s2.release();
    }
}
