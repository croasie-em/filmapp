package com.demo.filmmanagement.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.filmmanagement.entity.Film;
import com.demo.filmmanagement.service.FilmService;



@RestController
@RequestMapping("/films")
public class FilmController {
	
	@Autowired
	private FilmService service;
	
    @GetMapping
    public ResponseEntity<List<Film>> getAllFilms() {
        List<Film> films = service.getAllFilms();
        return new ResponseEntity<>(films, HttpStatus.OK);
    }
    
    @GetMapping("/{filmId}")
    public ResponseEntity<Film> getFilmById(@PathVariable int filmId) {
        Optional<Film> film = service.getFilmById(filmId);
        return film.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping
    public ResponseEntity<Film> addFilm(@RequestBody Film film) {
        Film createdFilm = service.saveFilm(film);
        return new ResponseEntity<>(createdFilm, HttpStatus.CREATED);
    }
    
    @PutMapping("/{filmId}")
    public ResponseEntity<Film> updateFilm(@PathVariable int filmId, @RequestBody Film updatedFilm) {
        Optional<Film> existingFilm = service.getFilmById(filmId);
        if (existingFilm.isPresent()) {
            updatedFilm.setFilmid(filmId);
            Film savedFilm = service.saveFilm(updatedFilm);
            return new ResponseEntity<>(savedFilm, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
    @DeleteMapping("/{filmId}")
    public ResponseEntity<Void> deleteFilm(@PathVariable int filmId) {
        Optional<Film> existingFilm = service.getFilmById(filmId);
        if (existingFilm.isPresent()) {
            service.deleteFilm(filmId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    }
    
	
	
	


}
