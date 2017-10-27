package com.lulu.test.aop;

import com.lulu.model.aop.Person;
import com.lulu.model.aop.PersonProxyCglib;

/**
 * Created by Administrator on 2017/10/27.
 */
public class PersonProxyCglibTest {
    public static void main(String[] args) {
        PersonProxyCglib cglib = new PersonProxyCglib();
        Person person = (Person) cglib.getInstance(new Person());
        person.eat();

        Person person1 = (Person) cglib.getProxy(Person.class);
        person1.eat();
    }
}
