package com.lulu.model.aop;

/**
 * Created by Administrator on 2017/10/27.
 */
public class Person implements Animal{
    @Override
    public void eat() {
        System.out.println("吃饭");
    }
}
