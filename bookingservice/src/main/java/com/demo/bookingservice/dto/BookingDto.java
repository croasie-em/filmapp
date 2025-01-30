package com.demo.bookingservice.dto;

public class BookingDto {
	
    private int userId;
    private int filmId;
    private int cinemaId;
    private String bookingDate;
    
    public BookingDto () {
    	
    }

	public BookingDto(int userId, int filmId, int cinemaId, String bookingDate) {
		super();
		this.userId = userId;
		this.filmId = filmId;
		this.cinemaId = cinemaId;
		this.bookingDate = bookingDate;
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
		return "BookingDto [userId=" + userId + ", filmId=" + filmId + ", cinemaId=" + cinemaId + ", bookingDate="
				+ bookingDate + "]";
	}
    
    

}
