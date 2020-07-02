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
            @RequestParam(required = false, name = "id") Long id,
            @RequestParam(required = false, name = "courseName") String name,
            @RequestParam(required = false, name = "townName") String town
    ){
        if(id != null){
            // http://localhost:8080/customers?id=1
            return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
        }
        if(name != null){
            // http://localhost:8080/customers?courseName=algebra
            return new ResponseEntity(customerRepository.findByBookingsCourseName(name.toLowerCase()),HttpStatus.OK);
        }
        if(town != null){
            // http://localhost:8080/customers?townName=aberdeen
            return new ResponseEntity(customerRepository.findByTown(town.toLowerCase()),HttpStatus.OK);
        }
        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }
}
