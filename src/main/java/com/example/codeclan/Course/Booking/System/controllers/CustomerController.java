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
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    IBookingRepository bookingRepository;

    @Autowired
    ICourseRepository courseRepository;

    @Autowired
    ICustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity getAllCustomersAndFilters(
            @RequestParam(required = false, name = "courseName") String name
    ){
        if(name != null){
            // http://localhost:8080/customers?courseName=Algebra
            return new ResponseEntity(customerRepository.findByBookingsCourseName(name),HttpStatus.OK);
        }
        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }
}
