package com.gogakaka;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/sample")
    public String sample() {
        System.out.println("Controller!");
        return "sample";
    }
}
