package com.example.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movie.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
