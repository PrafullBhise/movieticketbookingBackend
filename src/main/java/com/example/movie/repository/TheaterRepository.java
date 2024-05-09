package com.example.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movie.entity.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Long> {

}
