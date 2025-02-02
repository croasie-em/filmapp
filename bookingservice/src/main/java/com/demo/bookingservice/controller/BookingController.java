package com.demo.bookingservice.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bookingservice.dto.BookingDto;
import com.demo.bookingservice.entity.Booking;
import com.demo.bookingservice.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	
    @Autowired
    private BookingService bookingService;
    
    @GetMapping("/all")
    public ResponseEntity<List<Map<String, Object>>> getAllBookings() {
        List<Map<String, Object>> bookingsDetails = bookingService.getAllBookings();
        return new ResponseEntity<>(bookingsDetails, HttpStatus.OK);
    }
    
    @GetMapping("/{bookingId}")
    public Map<String, Object> getBookingDetails(@PathVariable int bookingId) {
        return bookingService.getBookingDetails(bookingId);
    }
    
    @PostMapping("/add")
    public Map<String, Object> addBooking(@RequestBody BookingDto bookingDto) {
        return bookingService.addBooking(bookingDto);
    }
    
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookingsList() {
        List<Booking> bookings = bookingService.getAllBookingsList();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
}
