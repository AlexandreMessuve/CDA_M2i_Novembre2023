package com.example.library_aspect.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    @After("@annotation(com.example.library_aspect.annotation.Log)")
    public void logAfterBookService(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Method name : " + methodName);
        System.out.println("Args : " + Arrays.toString(joinPoint.getArgs()));
    }
}
