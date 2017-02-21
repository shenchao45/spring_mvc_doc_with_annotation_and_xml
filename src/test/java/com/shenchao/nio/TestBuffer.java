package com.shenchao.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.CountDownLatch;

/**
 * Created by shenchao on 2017/2/6.
 */
public class TestBuffer {
    @Test
    public void tset1(){
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("hello".getBytes());
        System.out.println(buffer.capacity());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println("-------------------------");
        buffer.flip();
        System.out.println(buffer.capacity());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println("-------------------------");
        byte[] bytes = new byte[1024];
        buffer.get(bytes);
        buffer.reset();
        buffer.rewind();
    }
    @Test
    public void testChannel() throws Exception {
        long start = System.currentTimeMillis();
        CountDownLatch latch = new CountDownLatch(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileInputStream in = new FileInputStream("E:\\BaiduYunDownload\\juc.zip");
                    FileOutputStream out = new FileOutputStream("E:\\BaiduYunDownload\\juc1.zip");
                    FileChannel inChannel = in.getChannel();
                    FileChannel outChannel = out.getChannel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    while (inChannel.read(buffer) != -1) {
                        buffer.flip();
                        outChannel.write(buffer);
                        buffer.clear();
                    }
                    inChannel.close();
                    outChannel.close();
                    in.close();
                    out.close();
                    latch.countDown();
                } catch (Exception e) {
                }
            }
        }).start();
        latch.await();
        System.out.println(System.currentTimeMillis()-start);
    }
    @Test
    public void testChannel1(){

    }
}
