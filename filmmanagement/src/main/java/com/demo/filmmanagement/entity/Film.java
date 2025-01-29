package com.demo.filmmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Film {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int filmid;
	
	@Column(nullable = false, unique = true) // film name got to be unique
	private String filmName;
    @Column(nullable = false)
    private String genre;
    @Column(nullable = false, unique = true) // set description as unique
    private String description;
    @Column(nullable = false)
    private String rating;
    @Column(nullable = false)
    private int runTime;
    
    public Film () {
    	
    }

	public Film(int filmid, String filmName, String genre, String description, String rating, int runTime) {
		super();
		this.filmid = filmid;
		this.filmName = filmName;
		this.genre = genre;
		this.description = description;
		this.rating = rating;
		this.runTime = runTime;
	}

	public int getFilmid() {
		return filmid;
	}

	public void setFilmid(int filmid) {
		this.filmid = filmid;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getRunTime() {
		return runTime;
	}

	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}

	@Override
	public String toString() {
		return "Film [filmid=" + filmid + ", filmName=" + filmName + ", genre=" + genre + ", description=" + description
				+ ", rating=" + rating + ", runTime=" + runTime + "]";
	}
    
    
    

}
