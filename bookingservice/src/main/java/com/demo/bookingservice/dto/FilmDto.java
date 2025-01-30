package com.demo.bookingservice.dto;



public class FilmDto {
    private int filmid;
    private String filmName;
    private String genre;
    private String description;
    private String rating;
    private int runTime;

    
    public FilmDto() {
    }

   
    public FilmDto(int filmid, String filmName, String genre, String description, String rating, int runTime) {
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
        return "FilmDto [filmid=" + filmid + ", filmName=" + filmName + ", genre=" + genre 
                + ", description=" + description + ", rating=" + rating + ", runTime=" + runTime + "]";
    }
}

