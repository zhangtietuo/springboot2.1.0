package com.ztt.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/2/22 16:06
 */
@Component
@Aspect
public class ZttAspectj {

    @Pointcut("execution(* com.ztt.service.*.*(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before() {
        System.out.println("================before method=====================");
    }
}
