package com.iagorubio.ioweb.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetRestController {
    @GetMapping("/greet")
    public String index() {
        return "Greetings !";
    }
}
