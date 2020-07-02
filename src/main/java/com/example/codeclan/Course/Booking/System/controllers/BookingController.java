package com.example.codeclan.Course.Booking.System.controllers;

import com.example.codeclan.Course.Booking.System.respositories.IBookingRepository;
import com.example.codeclan.Course.Booking.System.respositories.ICourseRepository;
import com.example.codeclan.Course.Booking.System.respositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    @Autowired
    IBookingRepository bookingRepository;

    @Autowired
    ICourseRepository courseRepository;

    @Autowired
    ICustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity getAllBookingsAndFilters(
            @RequestParam(required = false, name = "date") String date
    ){
        if(date != null){
            // http://localhost:8080/bookings?date=01-01-21
            return new ResponseEntity(bookingRepository.findByDate(date), HttpStatus.OK);
        }

        return new ResponseEntity(bookingRepository.findAll(), HttpStatus.OK);
    }
}
