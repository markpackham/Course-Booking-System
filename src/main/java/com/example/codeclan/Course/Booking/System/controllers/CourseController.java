package com.example.codeclan.Course.Booking.System.controllers;

import com.example.codeclan.Course.Booking.System.models.Course;
import com.example.codeclan.Course.Booking.System.models.Customer;
import com.example.codeclan.Course.Booking.System.respositories.IBookingRepository;
import com.example.codeclan.Course.Booking.System.respositories.ICourseRepository;
import com.example.codeclan.Course.Booking.System.respositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    IBookingRepository bookingRepository;

    @Autowired
    ICourseRepository courseRepository;

    @Autowired
    ICustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity getAllCoursesAndFilters(
            @RequestParam(required = false, name = "id") Long id,
            @RequestParam(required = false, name = "star") Integer star,
            @RequestParam(required = false, name = "town") String town,
            @RequestParam(required = false, name = "customerName") String name
    ){

        if(id != null){
            // http://localhost:8080/courses?id=1
            return new ResponseEntity(courseRepository.findById(id), HttpStatus.OK);
        }


        if(star != null){
            // http://localhost:8080/courses?star=1
            return new ResponseEntity(courseRepository.findByStar(star), HttpStatus.OK);
        }

        if(name != null){
            // http://localhost:8080/courses?customerName=alice
            return new ResponseEntity(courseRepository.findByBookingsCustomerName(name.toLowerCase()),HttpStatus.OK);
        }
        if(town != null){
            // http://localhost:8080/courses?town=aberdeen
            return new ResponseEntity(courseRepository.findByTown(town.toLowerCase()),HttpStatus.OK);
        }

        return new ResponseEntity(courseRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> postCourse(@RequestBody Course course){
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }
}
