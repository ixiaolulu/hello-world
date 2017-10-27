package com.lulu.model.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/10/27.
 */
public class OutPutter {
    //锁对象
    private  ReentrantLock  lock = new ReentrantLock();

    public void output(String name) {
        //获取锁
        lock.lock();
        System.out.println(Thread.currentThread()+":"+name+":加锁:"+lock.toString());
        System.out.println(lock.getHoldCount()+":"+lock.isLocked());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            for (int i = 0; i < name.length(); i++) {
                System.out.println(name.charAt(i));
            }
        } finally {
            //释放锁
            lock.unlock();
            System.out.println(Thread.currentThread()+":"+name+":释放锁:"+lock.toString());
            System.out.println(lock.getHoldCount()+":"+lock.isLocked());
        }
    }


}
