package com.demo.cinemamanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.cinemamanagement.entity.Cinema;




public interface CinemaRepo extends JpaRepository<Cinema, Integer>{
	
	List<Cinema> findByCinemaName(String cinemaName);


}
