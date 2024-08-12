package com.example.aspect.controller;

import com.example.aspect.service.AspectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AspectController {
    private  final AspectService aspectService;

    public AspectController(AspectService aspectService) {
        this.aspectService = aspectService;
    }

    @GetMapping("/")
    public String index() {
        aspectService.method();
        aspectService.method2();
        aspectService.methodWithResult();
        return "Method end";
    }
}
