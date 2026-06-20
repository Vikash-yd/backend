package com.SoulSpace.backend.Controllers;

import com.SoulSpace.backend.Models.Hall;
import com.SoulSpace.backend.Repositories.HallRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/halls")
@CrossOrigin(origins = "http://localhost:5173")
public class HallController {

    @Autowired
    private HallRepository hallRepository;

    @GetMapping
    public List<Hall> getAllHalls() {
        return hallRepository.findAll();
    }

    @GetMapping("/{id}")
    public Hall getHallById(@PathVariable Long id) {
        return hallRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hall not found"));
    }

    @GetMapping("/test")
    public String test() {
        return "Hall Controller Working";
    }
}