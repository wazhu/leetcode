package wazhu.leetcode;

import java.util.concurrent.Semaphore;

public class LeetCode_1114 {
    private Semaphore firstSemaphore = new Semaphore(0);
    private Semaphore sencodSemaphore = new Semaphore(0);


//    public Foo() {
//    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstSemaphore.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstSemaphore.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        sencodSemaphore.release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        sencodSemaphore.acquire();
        printThird.run();
    }
}
