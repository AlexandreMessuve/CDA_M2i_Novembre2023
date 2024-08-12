package com.example.aspect.service;

import org.springframework.stereotype.Service;

@Service
public class AspectService {

    public void method(){
        System.out.println("Log application in method AspectService");
    }

    public void method2(){

    }

    public String methodWithResult(){
        return "result";
    }
}
