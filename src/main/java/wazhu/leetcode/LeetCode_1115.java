package wazhu.leetcode;

import java.util.concurrent.Semaphore;

public class LeetCode_1115 {
    private int n;

    private Semaphore fooSemaphonre = new Semaphore(0);
    private Semaphore barSemaphonre = new Semaphore(0);

    public LeetCode_1115(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            barSemaphonre.acquire();
            printFoo.run();
            fooSemaphonre.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            fooSemaphonre.acquire();
            printBar.run();
            barSemaphonre.release();
        }
    }
}
