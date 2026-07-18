package com.dqm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Queue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long queueId;

    private String queueName;

    private String status;

    private int currentToken;

    private int estimatedWaitTime;

    private int maxCapacity;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}