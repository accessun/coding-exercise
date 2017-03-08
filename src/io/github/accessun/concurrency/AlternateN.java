package io.github.accessun.concurrency;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * N threads print 1, 2, 3 alternately.
 */
public class AlternateN {

    public static void main(String[] args) {
        SimpleCyclicList<Integer> cycle = new SimpleCyclicList<>(Arrays.asList(1, 2, 3));

        Lock lock = new ReentrantLock();
        Condition cond = lock.newCondition();

        for (int i = 0; i < 10; i++) {
            new Thread(new PrintX(cycle, lock, cond)).start();
        }
    }

}

class PrintX implements Runnable {

    private SimpleCyclicList<Integer> cycle;
    private Lock lock;
    private Condition cond;

    public PrintX(SimpleCyclicList<Integer> cycle, Lock lock, Condition cond) {
        this.cycle = cycle;
        this.lock = lock;
        this.cond = cond;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                System.out.println(cycle.next());
                cond.signalAll();
                try {
                    cond.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } finally {
                lock.unlock();
            }
        }
    }

}