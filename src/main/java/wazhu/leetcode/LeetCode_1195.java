package wazhu.leetcode;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class LeetCode_1195 {
    private int n;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private AtomicInteger value;

    public LeetCode_1195(int n) {
        this.n = n;
        value = new AtomicInteger(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (value.intValue() <= n) {
            lock.lock();
            if (value.intValue() % 3 == 0 && value.intValue() % 5 != 0) {
                printFizz.run();
                value.incrementAndGet();
                condition.signalAll();
            } else {
                condition.await();
            }
            lock.unlock();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (value.intValue() <= n) {
            lock.lock();
            if (value.intValue() % 5 == 0 && value.intValue() % 3 != 0) {
                printBuzz.run();
                value.incrementAndGet();
                condition.signalAll();
            } else {
                condition.await();
            }
            lock.unlock();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (value.intValue() <= n) {
            lock.lock();
            if (value.intValue() % 5 == 0 && value.intValue() % 3 == 0) {
                printFizzBuzz.run();
                value.incrementAndGet();
                condition.signalAll();
            } else {
                condition.await();
            }
            lock.unlock();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (value.intValue() <= n) {
            lock.lock();
            if (value.intValue() % 5 != 0 && value.intValue() % 3 != 0) {
                printNumber.accept(value.intValue());
                value.incrementAndGet();
                condition.signalAll();
            } else {
                condition.await();
            }
            lock.unlock();
        }
    }
}
