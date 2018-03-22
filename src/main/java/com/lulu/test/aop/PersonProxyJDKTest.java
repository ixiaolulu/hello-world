package com.lulu.test.aop;

import com.lulu.model.aop.Animal;
import com.lulu.model.aop.Person;
import com.lulu.model.aop.PersonProxyJDK;

import java.lang.reflect.Proxy;

/**
 * JDK动态代理模式
 */
public class PersonProxyJDKTest {
    public static void main(String[] args) {
        Person p = new Person();
        PersonProxyJDK personProxyJDK = new PersonProxyJDK(p);
        Animal animal = (Animal) Proxy.newProxyInstance(PersonProxyJDKTest.class.getClassLoader(),p.getClass().getInterfaces(),personProxyJDK);
        animal.eat();
    }

}
