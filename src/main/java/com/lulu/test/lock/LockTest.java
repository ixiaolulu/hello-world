package com.lulu.test.lock;


import com.lulu.model.lock.OutPutter;

/**
 * lock锁测试
 */
public class LockTest {

    public static void main(String[] args) {
        final OutPutter outPutter = new OutPutter();
//        OutPutter outPutter = new OutPutter();
       //开启一个线程
        new Thread(){
            @Override
            public void run() {
                outPutter.output("1");
            }
        }.start();
        //开启第二个线程
        new Thread(){
            @Override
            public void run() {
                outPutter.output("2");
            }
        }.start();

    }

}
