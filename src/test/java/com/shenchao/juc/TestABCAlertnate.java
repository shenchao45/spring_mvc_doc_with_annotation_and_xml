package com.shenchao.juc;

import java.util.concurrent.locks.*;

/**
 * Created by shenchao on 2017/2/5.
 */
public class TestABCAlertnate {

}
class AlertnateDemo{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    public void loopA(){
        lock.lock();
        try {
            if (number != 1) {
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int i =1;i<=5;i++) {
                System.out.println(Thread.currentThread().getName()+"A");
            }
        }finally {
            lock.unlock();
        }
    }
}
