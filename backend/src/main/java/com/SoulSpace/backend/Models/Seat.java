package com.SoulSpace.backend.Models;

import jakarta.persistence.*;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;

    private boolean booked;

    private Long hallId;

    // 🔥 NEW FIELD (IMPORTANT)
    private Long userId;

    public Seat() {}

    public Seat(String seatNumber, boolean booked, Long hallId) {
        this.seatNumber = seatNumber;
        this.booked = booked;
        this.hallId = hallId;
    }

    public Long getId() {
        return id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }

    // 🔥 NEW GETTER/SETTER
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}