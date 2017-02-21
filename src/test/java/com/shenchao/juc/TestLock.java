package com.shenchao.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shenchao on 2017/2/4.
 */
public class TestLock {
    public static void main(String[] args) {
        Tick tick = new Tick();
        new Thread(tick, "1号窗口").start();
        new Thread(tick, "2号窗口").start();
        new Thread(tick, "3号窗口").start();
    }
}
class Tick implements Runnable{

    private Lock lock = new ReentrantLock();
    private int tick = 1009;
    @Override
    public void run() {
        while (true) {
//            lock.lock();
            synchronized (this) {
                try {
                    if (tick > 0) {
                        Thread.sleep(200);
                        System.out.println(Thread.currentThread().getName()+":"+tick--);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
//                lock.unlock();
                }
            }
        }
    }
}