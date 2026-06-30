package com.SoulSpace.backend.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "seats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String seatNumber;

    @Column(nullable = false)
    private Long hallId;

    // Floor number
    private Integer floor;

    // Example: Silent Zone, Discussion Zone, Premium Zone
    private String zone;

    // Example: East Wing, Window Side, Corner
    private String location;

    @Builder.Default
    @Column(nullable = false)
    private Boolean hasChargingPort = false;

    @Builder.Default
    @Column(nullable = false)
    private Boolean nearWindow = false;

    @Builder.Default
    @Column(nullable = false)
    private Boolean active = true;
}