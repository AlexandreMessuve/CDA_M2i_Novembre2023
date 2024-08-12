package com.example.aspect.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectAdvice {

    // La totalité des méthodes de chaque objet créé à partir d'une classe à l'interieur du package service
    @Before("execution(* com.example.aspect.service.*.*(..))")
    public void addBeforeEachServicesMethods() {
        System.out.println("Run before each method's services");
    }

    @After("execution(* com.example.aspect.service.*.*(..))")
    public void addAfterEachServicesMethods() {
        System.out.println("Run After each method's services");
    }

    @AfterReturning(value = "execution(* com.example.aspect.service.AspectService.methodWithResult(..))", returning = "result")
    public void addAfterReturningEachServicesMethods(Object result) {
        System.out.println("Run After Returning each method's services "+result);
    }

    @AfterThrowing("execution(* com.example.aspect.service.*.*(..))")
    public void addAfterThrowingServicesMethods() {
        System.out.println("Run After Throwing each method's services");
    }
}
