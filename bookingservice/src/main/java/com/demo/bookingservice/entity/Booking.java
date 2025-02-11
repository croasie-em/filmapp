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
	
    @Column(nullable = false)
    private int userId;
    @Column(nullable = false)
    private int filmId; 
    @Column(nullable = false)
    private int cinemaId;
    @Column(nullable = false)
    private String bookingDate;
    
    public Booking() {
    	
    }
    
    



	public Booking(int bookingid, int userId, int filmId, int cinemaId, String bookingDate) {
		super();
		this.bookingid = bookingid;
		this.userId = userId;
		this.filmId = filmId;
		this.cinemaId = cinemaId;
		this.bookingDate = bookingDate;
	}





	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public int getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}
	

	public String getBookingDate() {
		return bookingDate;
	}





	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}





	@Override
	public String toString() {
		return "Booking [bookingid=" + bookingid + ", userId=" + userId + ", filmId=" + filmId + ", cinemaId="
				+ cinemaId + ", bookingDate=" + bookingDate + "]";
	}
	
	



    
    

}
