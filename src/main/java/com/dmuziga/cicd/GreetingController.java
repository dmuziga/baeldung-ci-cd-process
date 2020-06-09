package com.dmuziga.cicd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello Docker File Uploaded!";
    private final AtomicLong counter = new AtomicLong(100);

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name",
            defaultValue="World") String name) {

        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
