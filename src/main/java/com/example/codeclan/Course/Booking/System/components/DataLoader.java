package com.example.codeclan.Course.Booking.System.components;

import com.example.codeclan.Course.Booking.System.models.Booking;
import com.example.codeclan.Course.Booking.System.models.Course;
import com.example.codeclan.Course.Booking.System.models.Customer;
import com.example.codeclan.Course.Booking.System.respositories.IBookingRepository;
import com.example.codeclan.Course.Booking.System.respositories.ICourseRepository;
import com.example.codeclan.Course.Booking.System.respositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    IBookingRepository bookingRepository;

    @Autowired
    ICourseRepository courseRepository;

    @Autowired
    ICustomerRepository customerRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args)  {

        Booking booking1 = new Booking("01-01-21");
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("02-02-22");
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("03-03-23");
        bookingRepository.save(booking3);

//        booking1.addCourse(course1);
//        booking1.addCustomer(customer1);
//
//        booking2.addCourse(course2);
//        booking2.addCustomer(customer2);
//
//        booking3.addCourse(course3);
//        booking3.addCustomer(customer3);

        Customer customer1 = new Customer("Alice","Aberdeen",10,booking1);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Bob","Berwick",20,booking2);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Margret","Cardiff",30,booking3);
        customerRepository.save(customer3);

        Course course1 = new Course("Algebra","Aberdeen",1,booking1);
        courseRepository.save(course1);

        Course course2 = new Course("Biology","Berwick",2,booking2);
        courseRepository.save(course2);

        Course course3 = new Course("Chemistry","Cardiff",3,booking3);
        courseRepository.save(course3);

    }
}
