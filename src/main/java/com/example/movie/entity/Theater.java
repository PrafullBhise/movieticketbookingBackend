package com.example.movie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int totalSeats;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public Theater(Long id, String name, int totalSeats) {
		super();
		this.id = id;
		this.name = name;
		this.totalSeats = totalSeats;
	}
	public Theater() {
		super();
	}
	@Override
	public String toString() {
		return "Theater [id=" + id + ", name=" + name + ", totalSeats=" + totalSeats + "]";
	}
 
    
    
}