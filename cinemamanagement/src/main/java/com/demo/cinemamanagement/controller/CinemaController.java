package com.demo.cinemamanagement.controller;

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
    public List<Cinema> getAllCinemas() {
        return service.getAllCinemas();
    }
    
    @GetMapping("/{cinemaid}")
    public ResponseEntity<Cinema> getCinemaById(@PathVariable int cinemaid) {
        Optional<Cinema> cinema = service.getCinemaById(cinemaid);
        return cinema.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping
    public Cinema addCinema(@RequestBody Cinema cinema) {
        return service.addCinema(cinema);
    }
    
    @PutMapping("/{cinemaid}")
    public ResponseEntity<Cinema> updateCinema(@PathVariable int cinemaid, @RequestBody Cinema updatedCinema) {
        Optional<Cinema> existingCinema = service.getCinemaById(cinemaid);
        if (existingCinema.isPresent()) {
            updatedCinema.setCinemaid(cinemaid); 
            Cinema savedCinema = service.addCinema(updatedCinema);
            return new ResponseEntity<>(savedCinema, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{cinemaid}")
    public ResponseEntity<Void> deleteCinema(@PathVariable int cinemaid) {
        Optional<Cinema> existingCinema = service.getCinemaById(cinemaid);
        if (existingCinema.isPresent()) {
            service.deleteCinema(cinemaid);
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
