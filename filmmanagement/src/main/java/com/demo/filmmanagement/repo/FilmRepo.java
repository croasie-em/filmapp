package com.demo.filmmanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.filmmanagement.entity.Film;



public interface FilmRepo extends JpaRepository<Film, Integer>{
	
	List<Film> findByGenre(String genre);
	List<Film> findByRating(String rating);
	List<Film> findByFilmNameContaining(String filmName);

}
