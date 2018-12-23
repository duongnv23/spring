package com.duongnv.spring.aop.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Log4j2
@Component
public class HelloAspect {

    @Pointcut("execution(* com.duongnv.spring.aop.service.Service.*(..))")
    public void pointcutService(){}


    @Before("pointcutService()")
    public void doBefore(){
        log.info("before");
    }

}
