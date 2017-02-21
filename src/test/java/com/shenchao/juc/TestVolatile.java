package com.shenchao.juc;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shenchao on 2017/2/4.
 */
public class TestVolatile {
    public static void main(String[] args) throws InterruptedException {
        Collections.synchronizedList(new ArrayList<>());
        ThreadDemo demo = new ThreadDemo();
        new Thread(demo).start();
        while (true) {
            if (ThreadDemo.flag) {
                System.out.println("llllllll");
                break;
            }
        }
    }
}
class ThreadDemo implements Runnable{
    public static volatile boolean flag;
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("修改了flag的值。。。。。");
    }
    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
