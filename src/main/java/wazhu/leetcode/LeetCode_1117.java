package wazhu.leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class LeetCode_1117 {

    private Semaphore hSemaphore = new Semaphore(2);
    private Semaphore oSemaphore = new Semaphore(1);
    private CyclicBarrier barrier = new CyclicBarrier(3);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSemaphore.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSemaphore.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        barrier.reset();
        oSemaphore.release();
        hSemaphore.release(2);
    }
}
