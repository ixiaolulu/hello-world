package com.lulu.test.aop;

import com.lulu.model.aop.Animal;
import com.lulu.model.aop.Person;
import com.lulu.model.aop.PersonProxyJDK;

/**
 * JDK动态代理模式
 */
public class PersonProxyJDKTest {
    public static void main(String[] args) {
        PersonProxyJDK personProxyJDK = new PersonProxyJDK();
        Animal animal = (Animal) personProxyJDK.bind(new Person());
        animal.eat();
    }

}
