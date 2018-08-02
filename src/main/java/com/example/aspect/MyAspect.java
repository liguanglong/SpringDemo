package com.example.aspect;

import com.example.util.ProxyUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author LiGuanglong
 * @date 2018/6/5
 */
@Aspect
public class MyAspect {
    //如果只有execution时，value可以省略
    @Before(value = "execution(* com.example.service.impl.UserServiceImpl.getUserById(..))")
    public void recordLogBefore(){
        System.out.println("Print Log Before");
    }


    @After("execution(* com.example.service.impl.UserServiceImpl.getUserById(..))")
    public void recordLogAfter(){
        System.out.println("Print Log After");
    }

    @Around("execution(* com.example.service.impl.UserServiceImpl.getUserById(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before");
        //joinPoint就是要代理的类，执行proceed()就是执行目标方法

        Object obj= null;
        try {
            obj = (Object) joinPoint.proceed();
            Object[] args = joinPoint.getArgs();
            System.out.println(args);
            ProxyUtils.saveProxyClass("D:\\git\\b.class", "MyServiceProxy", obj.getClass().getInterfaces());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            System.out.println("around finally");
        }

        System.out.println("around after");
        return obj;
    }

}
