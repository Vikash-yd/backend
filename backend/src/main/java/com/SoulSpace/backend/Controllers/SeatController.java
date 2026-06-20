package com.SoulSpace.backend.Controllers;

import com.SoulSpace.backend.Models.Seat;
import com.SoulSpace.backend.Repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seats")
@CrossOrigin(origins = "http://localhost:5173")
public class SeatController {

    @Autowired
    private SeatRepository seatRepository;

    @GetMapping("/hall/{hallId}")
    public List<Seat> getSeatsByHall(@PathVariable Long hallId) {
        return seatRepository.findByHallId(hallId);
    }

    @GetMapping("/my-seat")
    public ResponseEntity<?> getMySeat(
            @RequestParam Long userId
    ) {

        Optional<Seat> seat =
                seatRepository.findByUserId(userId);

        if (seat.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No seat booked");
        }

        return ResponseEntity.ok(seat.get());
    }

    @PostMapping("/book")
    @Transactional
    public ResponseEntity<?> bookSeat(
            @RequestParam String seatNumber,
            @RequestParam Long hallId,
            @RequestParam Long userId
    ) {

        try {

            Optional<Seat> existingSeat =
                    seatRepository.findByUserId(userId);

            if (existingSeat.isPresent()) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("You already have a booked seat. Please unbook it first.");
            }

            List<Seat> seats =
                    seatRepository.findBySeatNumberAndHallId(
                            seatNumber,
                            hallId
                    );

            if (seats.isEmpty()) {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Seat not found"
                );
            }

            Seat seat = seats.get(0);

            if (seat.isBooked()) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Seat already booked");
            }

            seat.setBooked(true);
            seat.setUserId(userId);

            seatRepository.save(seat);

            return ResponseEntity.ok(seat);

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @PostMapping("/unbook")
    @Transactional
    public ResponseEntity<?> unbookSeat(
            @RequestParam Long userId
    ) {

        Optional<Seat> seatOptional =
                seatRepository.findByUserId(userId);

        if (seatOptional.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No seat booked for this user");
        }

        Seat seat = seatOptional.get();

        seat.setBooked(false);
        seat.setUserId(null);

        seatRepository.save(seat);

        return ResponseEntity.ok("Seat unbooked successfully");
    }
}