package com.demo.bookingservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.bookingservice.dto.CinemaDto;
import com.demo.bookingservice.dto.FilmDto;
import com.demo.bookingservice.dto.UserDto;
import com.demo.bookingservice.entity.Booking;
import com.demo.bookingservice.repo.BookingRepo;

@Service
public class BookingService {
	
    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private RestTemplate restTemplate;

    public Map<String, Object> getBookingDetails(int bookingId) {
        
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        
        UserDto user = restTemplate.getForObject("http://localhost:8085/users/" + booking.getUserId(), UserDto.class);

        
        FilmDto film = restTemplate.getForObject("http://localhost:8083/films/" + booking.getFilmId(), FilmDto.class);

        
        CinemaDto cinema = restTemplate.getForObject("http://localhost:8082/cinemas/" + booking.getCinemaId(), CinemaDto.class);

        
        Map<String, Object> response = new HashMap<>();
        response.put("booking", booking);
        response.put("user", user);
        response.put("film", film);
        response.put("cinema", cinema);

        return response;
    }

}
