package com.demo.cinemamanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.cinemamanagement.entity.Cinema;
import com.demo.cinemamanagement.repo.CinemaRepo;


@Service
public class CinemaService {
	
	@Autowired
	private CinemaRepo cinemaRepo;
	
    public Cinema addCinema(Cinema cinema) {
        return cinemaRepo.save(cinema);
    }
    
    public List<Cinema> getAllCinemas() {
        return cinemaRepo.findAll();
    }
    
    public Optional<Cinema> getCinemaById(int cinemaid) {
        return cinemaRepo.findById(cinemaid);
    }
    
    public void deleteCinema(int cinemaid) {
    	cinemaRepo.deleteById(cinemaid);
    }
    

    public Cinema updateCinema(int cinemaid, Cinema updatedCinema) {
        return cinemaRepo.findById(cinemaid).map(cinema -> {
            cinema.setCinemaName(updatedCinema.getCinemaName());
            cinema.setCity(updatedCinema.getCity());
            cinema.setNumberOfScreens(updatedCinema.getNumberOfScreens());
            return cinemaRepo.save(cinema);
        }).orElseThrow(() -> new RuntimeException("Cinema not found"));
    }
    
    public List<Cinema> findByCinemaName(String cinemaName) {
        return cinemaRepo.findByCinemaName(cinemaName);
    }

}
