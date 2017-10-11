package com;

/**
 * @function:
 * @author: dingxianlu
 * @date: 2017/10/10 13:59
 */
public class TestWithoutVolatile {

    private static boolean bChanged;

    public static void main(String[] args) throws InterruptedException {
        new Thread() {

            @Override
            public void run() {
                for (; ; ) {
                    if (bChanged == !bChanged) {
                        System.out.println("!=");
                        System.exit(0);
                    }
                }
            }
        }.start();
        Thread.sleep(1);
        new Thread() {

            @Override
            public void run() {
                for (; ; ) {
                    bChanged = !bChanged;
                }
            }
        }.start();
    }

}
