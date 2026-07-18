package com.dqm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dqm.entity.Counter;
import com.dqm.repository.CounterRepository;

@Service
public class CounterService {

    @Autowired
    private CounterRepository counterRepository;

    public Counter saveCounter(Counter counter) {
        return counterRepository.save(counter);
    }

    public List<Counter> getAllCounters() {
        return counterRepository.findAll();
    }

    public Counter getCounterById(Long id) {
        return counterRepository.findById(id).orElse(null);
    }

    public Counter updateCounter(Long id, Counter counter) {
        counter.setCounterId(id);
        return counterRepository.save(counter);
    }

    public void deleteCounter(Long id) {
        counterRepository.deleteById(id);
    }
}