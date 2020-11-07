package leetcode;

import sun.awt.windows.ThemeReader;

import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;

    private volatile int state;

    private volatile boolean control = true;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (state != 0) {
                Thread.yield();
            }
            printNumber.accept(0);
            if (control) {
                state = 1;
            } else {
                state = 2;
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (state != 2) {
                Thread.yield();
            }
            printNumber.accept(i);
            control = true;
            state = 0;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (state != 1) {
                Thread.yield();
            }
            printNumber.accept(i);
            control = false;
            state = 0;
        }
    }
}
