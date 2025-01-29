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
	
    public Cinema saveCinema(Cinema cinema) {
        return cinemaRepo.save(cinema);
    }
    
    public List<Cinema> getAllCinemas() {
        return cinemaRepo.findAll();
    }
    
    public Optional<Cinema> getCinemaById(int cinemaId) {
        return cinemaRepo.findById(cinemaId);
    }
    
    public void deleteCinema(int cinemaId) {
    	cinemaRepo.deleteById(cinemaId);
    }
    
    public List<Cinema> findByCinemaName(String cinemaName) {
        return cinemaRepo.findByCinemaName(cinemaName);
    }

}
