package com.example.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie.entity.Booking;
import com.example.movie.entity.BookingRequest;
import com.example.movie.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking bookTickets(@RequestBody BookingRequest bookingRequest) {
        return bookingService.bookTickets(bookingRequest);
    }
}
