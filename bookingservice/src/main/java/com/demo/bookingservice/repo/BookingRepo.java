package com.demo.bookingservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.bookingservice.entity.Booking;



public interface BookingRepo extends JpaRepository<Booking, Integer>{

}
