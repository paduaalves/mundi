package br.com.alura.mvc.mundi.controller;

import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
    
    // @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
