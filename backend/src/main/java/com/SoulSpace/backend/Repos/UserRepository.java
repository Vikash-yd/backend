package com.SoulSpace.backend.Repos;

import com.SoulSpace.backend.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {
    // You can add custom queries here if needed
}