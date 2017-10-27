package com.lulu.model.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB动态代理类
 * 　这里需要注意的是实现MethodIntercetor接口，必须导入cglib-nodep-2.1_3.jar这个包。
 * CGLib是针对类来实现代理的，他的原理是对指定的目标生成一个子类，
 * 并覆盖其中方法实现增强，但因为采用的是继承，所以不能对final修饰的类进行代理。
 *
 */
public class PersonProxyCglib implements MethodInterceptor{

    private Object proxyObj;

    /**
     * 创建代理对象
     * @return
     */
    public Object getInstance(Object proxyObj){
        this.proxyObj = proxyObj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.proxyObj.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    /**
     * 创建代理对象
     */
    public <T> T getProxy(Class<T> clz){
        return (T)Enhancer.create(clz,this);
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("业务逻辑处理开始...");
        methodProxy.invokeSuper(obj, args);
        System.out.println("业务逻辑处理结束...");
        return null;
    }
}
