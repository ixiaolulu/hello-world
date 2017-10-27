package com.lullu.test.lock;

import com.lulu.model.OutPutter1;

/**
 * lock锁测试
 */
public class LockTest {

    public static void main(String[] args) {
        OutPutter1 outPutter1 = new OutPutter1();
//        OutPutter1 outPutter = new OutPutter1();
       //开启一个线程
        new Thread(){
            @Override
            public void run() {
                outPutter1.output("1");
            }
        }.start();
        //开启第二个线程
        new Thread(){
            @Override
            public void run() {
                outPutter1.output("2");
            }
        }.start();

    }

}
