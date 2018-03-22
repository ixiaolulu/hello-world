package com.lulu.model.aop;

/**
 * Created by Administrator on 2017/10/27.
 */
public class PersonProxy implements Animal {
    private Person person;

    public PersonProxy(Person person) {
        this.person = person;
    }

    public void eat() {
        System.out.println("eat begin...");
        person.eat();
        System.out.println("eat end...");
    }
}
