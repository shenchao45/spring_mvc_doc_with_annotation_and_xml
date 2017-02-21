package com.shenchao.juc;

import java.util.concurrent.CountDownLatch;

/**
 * Created by shenchao on 2017/2/4.
 */
public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(5);
        long startTime = System.currentTimeMillis();
        for(int i=0;i<5;i++) {
            new Thread(new MyRunnable(latch)).start();
        }
        latch.await();
        long endTime = System.currentTimeMillis();
        System.out.println("一共花了"+(endTime-startTime));
    }
}
class MyRunnable implements Runnable{

    private CountDownLatch countDownLatch;

    public MyRunnable(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            for(int i =0;i<50000;i++) {
                System.out.println(i);
            }
        }finally {
            countDownLatch.countDown();
        }
    }
}
