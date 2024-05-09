package com.example.movie.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Theater theater;
    private LocalDateTime bookingTime;
    @OneToMany(mappedBy = "booking")
    private List<SeatBooking> seatBookings;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Theater getTheater() {
		return theater;
	}
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	public LocalDateTime getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}
	public List<SeatBooking> getSeatBookings() {
		return seatBookings;
	}
	public void setSeatBookings(List<SeatBooking> seatBookings) {
		this.seatBookings = seatBookings;
	}
	public Booking(Long id, Movie movie, Theater theater, LocalDateTime bookingTime, List<SeatBooking> seatBookings) {
		super();
		this.id = id;
		this.movie = movie;
		this.theater = theater;
		this.bookingTime = bookingTime;
		this.seatBookings = seatBookings;
	}
	public Booking() {
		super();
	}
    
    
    
}