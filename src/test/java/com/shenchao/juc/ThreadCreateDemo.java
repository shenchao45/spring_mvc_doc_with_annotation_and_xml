package com.shenchao.juc;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by shenchao on 2017/2/4.
 */
public class ThreadCreateDemo {
    @Test
    public void testThreadCreate1() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new ThreadCallable());
        Thread thread = new Thread(futureTask);
        thread.start();
        Integer integer = futureTask.get();
        System.out.println(integer);
    }

}
class ThreadCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        Integer integer = 0;
        for(int i = 1;i<1000;i++) {
            integer += i;
        }
        return integer;
    }
}
