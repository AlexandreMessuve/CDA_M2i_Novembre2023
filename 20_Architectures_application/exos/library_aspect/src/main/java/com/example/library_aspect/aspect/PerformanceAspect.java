package com.example.library_aspect.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {

    @Around("@annotation(com.example.library_aspect.annotation.Performance)")
    public Object around(ProceedingJoinPoint joinPoint) {
        try {
            double startTime = System.currentTimeMillis();
            joinPoint.proceed();
            double endTime = System.currentTimeMillis();
            System.out.println("Process time: " + (endTime - startTime) + "ms");
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }finally {
            return null;
        }
    }
}
