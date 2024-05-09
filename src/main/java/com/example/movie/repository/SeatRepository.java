package com.example.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movie.entity.Seat;
import com.example.movie.entity.Theater;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByTheaterAndSeatNumberIn(Theater theater, List<String> seatNumbers);
    List<Seat> findByTheater(Theater theater);
}

