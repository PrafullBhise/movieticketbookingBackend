package com.example.movie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie.entity.Booking;
import com.example.movie.entity.BookingRequest;
import com.example.movie.entity.Movie;
import com.example.movie.entity.Seat;
import com.example.movie.entity.SeatBooking;
import com.example.movie.entity.Theater;
import com.example.movie.repository.BookingRepository;
import com.example.movie.repository.MovieRepository;
import com.example.movie.repository.SeatRepository;
import com.example.movie.repository.TheaterRepository;

import jakarta.transaction.Transactional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private MovieRepository movieRepository;

    // Method to book tickets
    @Transactional
    public Booking bookTickets(BookingRequest bookingRequest) {
        Theater theater = theaterRepository.findById(bookingRequest.getTheaterId())
                .orElseThrow(() -> new RuntimeException("Theater not found"));

        List<Seat> seats = seatRepository.findByTheaterAndSeatNumberIn(theater, bookingRequest.getSeatNumbers());
        if (seats.size() != bookingRequest.getSeatNumbers().size()) {
            throw new RuntimeException("One or more seats not found");
        }
        if (seats.stream().anyMatch(Seat::isBooked)) {
            throw new RuntimeException("One or more seats already booked");
        }

        Movie movie = movieRepository.findById(bookingRequest.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        Booking booking = new Booking();
        booking.setMovie(movie);
        booking.setTheater(theater);
        booking.setBookingTime(bookingRequest.getBookingTime());
        booking = bookingRepository.save(booking);

        List<SeatBooking> seatBookings = new ArrayList<>();
        for (Seat seat : seats) {
            seat.setBooked(true);
            seatRepository.save(seat);

            SeatBooking seatBooking = new SeatBooking();
            seatBooking.setSeat(seat);
            seatBooking.setBooking(booking);
            seatBookings.add(seatBooking);
        }
        booking.setSeatBookings(seatBookings);
        return booking;
    }
    
 // Method to get the IDs of available seats in a theater
    public List<Long> getAvailableSeatIds(Long theaterId) {
        Theater theater = theaterRepository.findById(theaterId)
                .orElseThrow(() -> new RuntimeException("Theater not found"));

        List<Seat> allSeatsInThisTheater = seatRepository.findByTheater(theater);

        return allSeatsInThisTheater.stream()
                .filter(seat -> !seat.isBooked())
                .map(Seat::getId)
                .collect(Collectors.toList());
    }

}
