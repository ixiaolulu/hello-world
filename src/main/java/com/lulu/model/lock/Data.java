package com.lulu.model.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁测试
 */
public class Data {

    //共享数据
    private String data;

    //读写锁
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    /**
     * 写数据,加lock
     */
    public void writeDataWithLock(String data) {
        //获取写的锁
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "准备写入数据:" + data);

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.data = data;

            System.out.println(Thread.currentThread().getName() + "写入：" + data);
        } finally {
            //释放写的锁
            readWriteLock.writeLock().unlock();
        }
    }

    /**
     * 读数据,加lock
     */
    public void readDataWithLock() {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "准备读取数据");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "读取：" + this.data);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    /**
     * 写数据
     */
    public void writeData(String data) {
        System.out.println(Thread.currentThread().getName() + "准备写入数据:" + data);

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.data = data;

        System.out.println(Thread.currentThread().getName() + "写入：" + data);

    }

    /**
     * 读数据
     */
    public void readData() {
        System.out.println(Thread.currentThread().getName() + "准备读取数据");
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "读取：" + this.data);
    }

    /**
     * 写数据,加synchronized
     */
    public synchronized void writeDataWithSyn(String data) {
        System.out.println(Thread.currentThread().getName() + "准备写入数据:" + data);

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.data = data;

        System.out.println(Thread.currentThread().getName() + "写入：" + data);

    }

    /**
     * 读数据，加synchronized
     */
    public synchronized void readDataWithSyn() {
        System.out.println(Thread.currentThread().getName() + "准备读取数据");
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "读取：" + this.data);
    }


}
