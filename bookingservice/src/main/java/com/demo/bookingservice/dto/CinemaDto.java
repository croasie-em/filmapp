package com.demo.bookingservice.dto;

public class CinemaDto {
	
	private int cinemaid;
    private String cinemaName;
    private String city;
    private String numberOfScreens;

    
    public CinemaDto() {
    }

    
    public CinemaDto(int cinemaid, String cinemaName, String city, String numberOfScreens) {
        this.cinemaid = cinemaid;
        this.cinemaName = cinemaName;
        this.city = city;
        this.numberOfScreens = numberOfScreens;
    }

    
    public int getCinemaid() {
        return cinemaid;
    }

    public void setCinemaid(int cinemaid) {
        this.cinemaid = cinemaid;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumberOfScreens() {
        return numberOfScreens;
    }

    public void setNumberOfScreens(String numberOfScreens) {
        this.numberOfScreens = numberOfScreens;
    }

    @Override
    public String toString() {
        return "CinemaDto [cinemaid=" + cinemaid + ", cinemaName=" + cinemaName + ", city=" + city + ", numberOfScreens=" + numberOfScreens + "]";
    }

}
