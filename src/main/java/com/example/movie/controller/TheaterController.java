package com.example.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie.service.BookingService;

@RestController
@RequestMapping("/api/theaters")
public class TheaterController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/{theaterId}/seats/available")
    public ResponseEntity<List<Long>> getAvailableSeatIds(@PathVariable Long theaterId) {
        List<Long> availableSeatIds = bookingService.getAvailableSeatIds(theaterId);
        return ResponseEntity.ok(availableSeatIds);
    }
}

