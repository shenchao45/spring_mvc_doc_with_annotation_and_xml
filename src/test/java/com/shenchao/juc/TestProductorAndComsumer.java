package com.shenchao.juc;

/**
 * Created by shenchao on 2017/2/5.
 */
public class TestProductorAndComsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);
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
class Clerk{
    private int product;

    public synchronized void product() throws InterruptedException {
        while (product >= 1) {
            System.out.println("产品已满");
            this.wait();
        }
        System.out.println(Thread.currentThread().getName()+":"+ ++product);
        this.notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        while (product <= 0) {
            System.out.println("缺货");
            this.wait();
        }
        System.out.println(Thread.currentThread().getName()+":"+ --product);
        this.notifyAll();
    }
}
class Productor implements Runnable{
    private Clerk clerk;

    public Productor(Clerk clerk) {
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
class Consumer implements Runnable{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
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