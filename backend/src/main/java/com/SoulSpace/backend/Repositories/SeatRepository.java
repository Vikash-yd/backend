package com.SoulSpace.backend.Repositories;

import com.SoulSpace.backend.Models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> findByHallId(Long hallId);

    List<Seat> findBySeatNumberAndHallId(
            String seatNumber,
            Long hallId
    );

    Optional<Seat> findByUserId(Long userId);

    List<Seat> findAllByUserId(Long userId);
}