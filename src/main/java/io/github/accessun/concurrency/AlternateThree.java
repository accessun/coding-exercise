package io.github.accessun.concurrency;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Three threads print 1, 2, 3 alternately.
 */
public class AlternateThree {

    public static void main(String[] args) {
        SimpleCyclicList<Integer> cycle = new SimpleCyclicList<>(Arrays.asList(1, 2, 3));

        Lock lock = new ReentrantLock();
        Condition cond = lock.newCondition();

        new Thread(new PrintA(cycle, lock, cond)).start();
        new Thread(new PrintB(cycle, lock, cond)).start();
        new Thread(new PrintC(cycle, lock, cond)).start();
    }

}

class PrintA implements Runnable {

    private SimpleCyclicList<Integer> cycle;
    private Lock lock;
    private Condition cond;

    public PrintA(SimpleCyclicList<Integer> cycle, Lock lock, Condition cond) {
        super();
        this.cycle = cycle;
        this.lock = lock;
        this.cond = cond;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {

                if (cycle.get() == 1) {
                    System.out.println("A");
                    cycle.advance();
                    cond.signalAll();
                    try {
                        cond.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            } finally {
                lock.unlock();
            }
        }
    }

}

class PrintB implements Runnable {

    private SimpleCyclicList<Integer> cycle;
    private Lock lock;
    private Condition cond;

    public PrintB(SimpleCyclicList<Integer> cycle, Lock lock, Condition cond) {
        super();
        this.cycle = cycle;
        this.lock = lock;
        this.cond = cond;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {

                if (cycle.get() == 2) {
                    System.out.println("B");
                    cycle.advance();
                    cond.signalAll();
                    try {
                        cond.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            } finally {
                lock.unlock();
            }
        }
    }

}

class PrintC implements Runnable {

    private SimpleCyclicList<Integer> cycle;
    private Lock lock;
    private Condition cond;

    public PrintC(SimpleCyclicList<Integer> cycle, Lock lock, Condition cond) {
        super();
        this.cycle = cycle;
        this.lock = lock;
        this.cond = cond;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {

                if (cycle.get() == 3) {
                    System.out.println("C");
                    cycle.advance();
                    cond.signalAll();
                    try {
                        cond.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            } finally {
                lock.unlock();
            }
        }
    }

}