package com.demo.cinemamanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cinemamanagement.entity.Cinema;
import com.demo.cinemamanagement.service.CinemaService;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {
	
	@Autowired
	CinemaService service;
	
    @GetMapping
    public ResponseEntity<List<Cinema>> getAllCinemas() {
        List<Cinema> cinemas = service.getAllCinemas();
        return new ResponseEntity<>(cinemas, HttpStatus.OK);
    }
    
    @GetMapping("/{cinemaId}")
    public ResponseEntity<Cinema> getCinemaById(@PathVariable int cinemaId) {
        Optional<Cinema> cinema = service.getCinemaById(cinemaId);
        return cinema.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PutMapping("/{cinemaId}")
    public ResponseEntity<Cinema> updateCinema(@PathVariable int cinemaId, @RequestBody Cinema updatedCinema) {
        Optional<Cinema> existingCinema = service.getCinemaById(cinemaId);
        if (existingCinema.isPresent()) {
            updatedCinema.setCinemaid(cinemaId); // Ensure correct ID assignment before saving
            Cinema savedCinema = service.saveCinema(updatedCinema);
            return new ResponseEntity<>(savedCinema, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{cinemaId}")
    public ResponseEntity<Void> deleteCinema(@PathVariable int cinemaId) {
        Optional<Cinema> existingCinema = service.getCinemaById(cinemaId);
        if (existingCinema.isPresent()) {
            service.deleteCinema(cinemaId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Cinema>> findCinemaByName(@RequestParam String name) {
        List<Cinema> cinemas = service.findByCinemaName(name);
        return new ResponseEntity<>(cinemas, HttpStatus.OK);
    }

}
