package com.SoulSpace.backend.Models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role; // Enum: ADMIN, MEMBER, LIBRARIAN

    private LocalDateTime membershipDate = LocalDateTime.now();

    private Boolean isActive = true;

    private String phoneNumber;

    private String address;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    // Getters and setters
    // Constructors
}

enum Role {
    ADMIN,
    MEMBER,
    LIBRARIAN
}
