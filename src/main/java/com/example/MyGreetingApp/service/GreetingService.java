package com.example.MyGreetingApp.service;

import com.example.MyGreetingApp.model.Greeting;
import com.example.MyGreetingApp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GreetingService {
    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Optional<Greeting> updateGreeting(Long id, String newMessage) {
        Optional<Greeting> existingGreeting = greetingRepository.findById(id);
        if (existingGreeting.isPresent()) {
            Greeting greeting = existingGreeting.get();
            greeting.setMessage(newMessage);
            return Optional.of(greetingRepository.save(greeting));
        }
        return Optional.empty();
    }
}
