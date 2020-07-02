package com.example.codeclan.Course.Booking.System.controllers;

import com.example.codeclan.Course.Booking.System.models.Customer;
import com.example.codeclan.Course.Booking.System.respositories.IBookingRepository;
import com.example.codeclan.Course.Booking.System.respositories.ICourseRepository;
import com.example.codeclan.Course.Booking.System.respositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            @RequestParam(required = false, name = "townName") String town,
            @RequestParam(required = false, name = "age") Integer age
    ){
        // http://localhost:8080/customers?courseName=algebra&&townName=aberdeen
        if(name != null && town != null && age != null){
            return new ResponseEntity(customerRepository.findByBookingsCourseNameAndBookingsCourseTownAndAgeGreaterThan(name,town,age), HttpStatus.OK);
        }
        // http://localhost:8080/customers?courseName=algebra&&townName=aberdeen&&age=9
        if(name != null && town != null){
            return new ResponseEntity(customerRepository.findByBookingsCourseNameAndBookingsCourseTown(name,town), HttpStatus.OK);
        }
        if(id != null){
            // http://localhost:8080/customers?id=1
            return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
        }
        if(name != null){
            // http://localhost:8080/customers?courseName=algebra
            return new ResponseEntity(customerRepository.findByBookingsCourseName(name.toLowerCase()),HttpStatus.OK);
        }
        if(town != null) {
            // http://localhost:8080/customers?townName=aberdeen
            return new ResponseEntity(customerRepository.findByTown(town.toLowerCase()), HttpStatus.OK);
        }
        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
        public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

}


