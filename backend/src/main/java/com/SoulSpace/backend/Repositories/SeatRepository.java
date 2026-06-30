package com.SoulSpace.backend.Repositories;

import com.SoulSpace.backend.Models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> findByHallId(Long hallId);

    Optional<Seat> findBySeatNumber(String seatNumber);

    Optional<Seat> findBySeatNumberAndHallId(String seatNumber, Long hallId);

    List<Seat> findByActiveTrue();

    List<Seat> findByHallIdAndActiveTrue(Long hallId);
}