package com.shenchao.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shenchao on 2017/2/5.
 */
public class TestProductorAndComsumerForLock {
    public static void main(String[] args) {
        ClerkForLock clerk = new ClerkForLock();
        ProductorForLock productor = new ProductorForLock(clerk);
        ConsumerForLock consumer = new ConsumerForLock(clerk);
        Thread productThreadA = new Thread(productor, "生产者A");
        Thread consumeThreadA = new Thread(consumer, "消费者A");
        Thread productThreadB = new Thread(productor, "生产者B");
        Thread consumeThreadB = new Thread(consumer, "消费者B");
        productThreadA.start();
        productThreadB.start();
        consumeThreadA.start();
        consumeThreadB.start();
    }
}
class ClerkForLock{
    private int product;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void product() throws InterruptedException {
        lock.lock();
        while (product >= 1) {
            System.out.println("产品已满");
            condition.await();
        }
        System.out.println(Thread.currentThread().getName()+":"+ ++product);
        condition.signalAll();
        lock.unlock();
    }

    public void consume() throws InterruptedException {
        lock.lock();
        while (product <= 0) {
            System.out.println("缺货");
            condition.await();
        }
        System.out.println(Thread.currentThread().getName()+":"+ --product);
        condition.signalAll();
        lock.unlock();
    }
}
class ProductorForLock implements Runnable{
    private ClerkForLock clerk;

    public ProductorForLock(ClerkForLock clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for(int i=0;i<20;i++) {
            try {
                clerk.product();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class ConsumerForLock implements Runnable{
    private ClerkForLock clerk;

    public ConsumerForLock(ClerkForLock clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for(int i=0;i<20;i++) {
            try {
                clerk.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
