package com.demo.bookingservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.bookingservice.dto.BookingDto;
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
    
    public List<Booking> getAllBookingsList() {
        return bookingRepo.findAll();
    }
    
    public List<Map<String, Object>> getAllBookings() {
        List<Booking> bookings = bookingRepo.findAll();
        List<Map<String, Object>> bookingsDetails = new ArrayList<>();

        for (Booking booking : bookings) {
            UserDto user = restTemplate.getForObject("http://localhost:8085/users/" + booking.getUserId(), UserDto.class);
            FilmDto film = restTemplate.getForObject("http://localhost:8083/films/" + booking.getFilmId(), FilmDto.class);
            CinemaDto cinema = restTemplate.getForObject("http://localhost:8082/cinemas/" + booking.getCinemaId(), CinemaDto.class);

            Map<String, Object> response = new HashMap<>();
            response.put("booking", booking);
            response.put("user", user);
            response.put("film", film);
            response.put("cinema", cinema);

            bookingsDetails.add(response);
        }
        return bookingsDetails;
    }

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
    
    public Map<String, Object> addBooking(BookingDto bookingDto) {
        
        Booking booking = new Booking();
        booking.setUserId(bookingDto.getUserId());
        booking.setFilmId(bookingDto.getFilmId());
        booking.setCinemaId(bookingDto.getCinemaId());
        booking.setBookingDate(bookingDto.getBookingDate());

        
        bookingRepo.save(booking);

        
        UserDto user = restTemplate.getForObject("http://localhost:8085/users/" + bookingDto.getUserId(), UserDto.class);
        FilmDto film = restTemplate.getForObject("http://localhost:8083/films/" + bookingDto.getFilmId(), FilmDto.class);
        CinemaDto cinema = restTemplate.getForObject("http://localhost:8082/cinemas/" + bookingDto.getCinemaId(), CinemaDto.class);

        // Return the newly created booking along with related entities
        Map<String, Object> response = new HashMap<>();
        response.put("booking", booking);
        response.put("user", user);
        response.put("film", film);
        response.put("cinema", cinema);

        return response;
    }
    

}
