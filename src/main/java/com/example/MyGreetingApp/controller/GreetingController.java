package com.example.MyGreetingApp.controller;

import com.example.MyGreetingApp.model.Greeting;
import com.example.MyGreetingApp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/find/{id}")
    public Optional<Greeting> findGreetingById(@PathVariable Long id) {
        return greetingService.findGreetingById(id);
    }
}
