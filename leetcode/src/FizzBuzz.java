
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private int state = -1;
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if(i%15==0)
                continue;
            lock.lock();
            while (state!=3)
                cond.await();
            printFizz.run();
            state = -1;
            cond.signalAll();
            lock.unlock();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i+=5) {
            if(i%15==0)
                continue;
            lock.lock();
            while (state!=5)
                cond.await();
            printBuzz.run();
            state = -1;
            cond.signalAll();
            lock.unlock();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i+=15) {
            lock.lock();
            while (state!=15)
                cond.await();
            printFizzBuzz.run();
            state = -1;
            cond.signalAll();
            lock.unlock();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            lock.lock();
            while (state!=-1)
                cond.await();
            if(i%3!=0&&i%5!=0)
                printNumber.accept(i);
            else {
                if(i%15==0)
                    state = 15;
                else if(i%5==0)
                    state = 5;
                else
                    state = 3;
                cond.signalAll();
            }
            lock.unlock();
        }
    }
}
