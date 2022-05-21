package com.basic_rest_api.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "User") String name) {

        return new Greeting(counter.getAndIncrement(), String.format(template, name));
    }

    @GetMapping("/")
    public String welcome() {
        return "Welcome to  our page! God is good";
    }

}
