package io.github.accessun.concurrency;

/*
 * Two threads print true and false alternately.
 */
public class AlternateTwo {
    static volatile boolean printTrue = true;
    static volatile int count = 10;

    public static void main(String[] args) {
        Object lock = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count > 0) {
                    synchronized (lock) {
                        if (printTrue) {
                            System.out.println(Thread.currentThread().getName() + ": " + true);
                            count--;
                            printTrue = false;
                            lock.notifyAll();
                            try {
                                if (count == 0)
                                    break;
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }, "T-TRUE").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count > 0) {
                    synchronized (lock) {
                        if (!printTrue) {
                            System.out.println(Thread.currentThread().getName() + ": " + false);
                            count--;
                            printTrue = true;
                            lock.notifyAll();
                            try {
                                if (count == 0)
                                    break;
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }, "T-FALSE").start();
    }

}
