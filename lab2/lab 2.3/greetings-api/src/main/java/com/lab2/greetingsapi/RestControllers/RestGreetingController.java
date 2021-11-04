package com.lab2.greetingsapi.RestControllers;

import com.lab2.greetingsapi.Models.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RestGreetingController {
    private static final String template = "Welcome, Mr./Ms. %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/welcome")
    public Greeting welcome(@RequestParam(name="lastname", required = false, defaultValue = "Snow")String lastname)
    {
        return new Greeting(counter.incrementAndGet(), String.format(template, lastname));
    }
}
