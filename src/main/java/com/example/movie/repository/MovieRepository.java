package com.example.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movie.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
