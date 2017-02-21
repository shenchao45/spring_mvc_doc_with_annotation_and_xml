package com.shenchao.juc;

import java.util.concurrent.*;

/**
 * Created by shenchao on 2017/2/5.
 */
public class TestThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
//        ScheduledFuture<Integer> schedule = scheduledExecutorService.schedule(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                int i = 0;
//                for (int j = 0; j < 100; j++) {
//                    i += j;
//                }
//                System.out.println(i);
//                return i;
//            }
//        }, 3, TimeUnit.SECONDS);
//        ScheduledFuture<Integer> schedule2 = scheduledExecutorService.schedule(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                int i = 0;
//                for (int j = 0; j < 1001; j++) {
//                    i += j;
//                }
//                System.out.println(i);
//                return i;
//            }
//        }, 3, TimeUnit.SECONDS);
    }
}
