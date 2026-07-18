package com.dqm.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class QueueToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;

    private int tokenNumber;

    private String status;

    private int positionInQueue;

    private int estimatedWaitTime;

    private LocalDateTime joinedAt;

    private LocalDateTime calledAt;

    private LocalDateTime completedAt;

    private LocalDateTime skippedAt;

    private LocalDateTime cancelledAt;

    private LocalDateTime graceExpiryTime;

    @ManyToOne
    @JoinColumn(name = "queue_id")
    private Queue queue;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}