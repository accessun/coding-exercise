package io.accessun.javafeature.concurrency;

public class AlternateTwo2 {
    private static class AlterPrint implements Runnable {
        private Object lock;
        private int num;
        private static int round = 10 * 2; // ten rounds
        public AlterPrint(Object lock, int num) {
            this.lock = lock;
            this.num = num;
        }
        @Override
        public void run() {
            while (true) {
                synchronized(lock) {
                    try {
                        lock.notifyAll();
                        if (--round < 0) break;
                        System.out.println("==========");
                        for (int i = 0; i < num; i++) {
                            System.out.println(Thread.currentThread().getName() + ": " + i);
                        }
                        lock.wait();
                    } catch (InterruptedException e) {
                        // ignore
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(new AlterPrint(lock, 3)).start();
        new Thread(new AlterPrint(lock, 5)).start();
    }
}
