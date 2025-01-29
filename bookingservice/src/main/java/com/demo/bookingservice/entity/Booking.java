package com.demo.bookingservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingid;
	
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user; 
    @ManyToOne
    @JoinColumn(name = "filmId", nullable = false)
    private Film film; 
    @ManyToOne
    @JoinColumn(name = "cinemaId", nullable = false)
    private Cinema cinema; 

}
