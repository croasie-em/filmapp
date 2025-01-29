package com.demo.cinemamanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cinema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cinemaid;
	
	@Column(nullable = false, unique = true) // pictures name got to be unique
	private String cinemaName;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false) 
    private String numberOfScreens;


	
	public Cinema () {
		
	}



	public Cinema(int cinemaid, String cinemaName, String city, String numberOfScreens) {
		super();
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
		return "Cinema [cinemaid=" + cinemaid + ", cinemaName=" + cinemaName + ", city=" + city + ", numberOfScreens="
				+ numberOfScreens + "]";
	}
	
	

}
