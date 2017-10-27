package com.lulu.test.lock;

import com.lulu.model.lock.Data;

import java.util.Random;

/**
 * Created by Administrator on 2017/10/27.
 */
public class ReadWriteLockTest {

    public static void main(String[] args) {
        final Data data = new Data();
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        data.writeDataWithLock(String.valueOf(new Random().nextInt(30)));
//                        data.writeDataWithSyn(String.valueOf(new Random().nextInt(30)));
                    }
                }
            }).start();
        };
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        data.readDataWithLock();
//                        data.readDataWithSyn();
                    }
                }
            }).start();
        };

    }


}
