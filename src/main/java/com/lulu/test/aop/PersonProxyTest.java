package com.lulu.test.aop;

import com.lulu.model.aop.Person;
import com.lulu.model.aop.PersonProxy;

/**
 * Created by Administrator on 2017/10/27.
 */
public class PersonProxyTest {
    public static void main(String[] args) {
        PersonProxy p = new PersonProxy(new Person());
        p.eat();
    }
}
