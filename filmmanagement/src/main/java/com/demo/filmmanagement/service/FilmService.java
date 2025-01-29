package com.demo.filmmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.filmmanagement.entity.Film;
import com.demo.filmmanagement.repo.FilmRepo;

@Service
public class FilmService {
	
    @Autowired
    private FilmRepo filmRepo;
    
    public Film saveFilm(Film film) {
        return filmRepo.save(film);
    }
    
    public List<Film> getAllFilms() {
        return filmRepo.findAll();
    }
    
    public Optional<Film> getFilmById(int filmId) {
        return filmRepo.findById(filmId);
    }
    
    public void deleteFilm(int filmId) {
        filmRepo.deleteById(filmId);
    }

}
