package com.lulu.model.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/10/27.
 */
public class PersonProxyJDK implements InvocationHandler {

    private Object proxyObj;

    public Object bind(Object proxyObj) {
        this.proxyObj = proxyObj;
        return Proxy.newProxyInstance(proxyObj.getClass().getClassLoader(), proxyObj.getClass().getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("业务处理开始...");
        result = method.invoke(proxyObj, args);
        System.out.println("业务处理结束...");
        return result;
    }
}
