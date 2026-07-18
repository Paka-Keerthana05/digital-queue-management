package com.dqm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dqm.entity.Counter;
import com.dqm.service.CounterService;

@RestController
@RequestMapping("/counters")
@CrossOrigin("*")
public class CounterController {

    @Autowired
    private CounterService counterService;

    @PostMapping
    public Counter saveCounter(@RequestBody Counter counter) {
        return counterService.saveCounter(counter);
    }

    @GetMapping
    public List<Counter> getAllCounters() {
        return counterService.getAllCounters();
    }

    @GetMapping("/{id}")
    public Counter getCounterById(@PathVariable Long id) {
        return counterService.getCounterById(id);
    }

    @PutMapping("/{id}")
    public Counter updateCounter(@PathVariable Long id,
                                 @RequestBody Counter counter) {
        return counterService.updateCounter(id, counter);
    }

    @DeleteMapping("/{id}")
    public void deleteCounter(@PathVariable Long id) {
        counterService.deleteCounter(id);
    }
}