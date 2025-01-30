package com.demo.bookingservice.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.demo.bookingservice.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	
    @Autowired
    private BookingService bookingService;
    
    @GetMapping("/{bookingId}")
    public Map<String, Object> getBookingDetails(@PathVariable int bookingId) {
        return bookingService.getBookingDetails(bookingId);
    }
}
