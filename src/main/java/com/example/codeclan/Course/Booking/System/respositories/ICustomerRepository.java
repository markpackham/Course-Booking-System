package com.example.codeclan.Course.Booking.System.respositories;

import com.example.codeclan.Course.Booking.System.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
        List<Customer> findByBookingsCourseName(String name);
        List<Customer> findByTown(String town);
        Customer findById(int id);
//        List<Customer> findByBookingsCourseNameAndBookingsCourseTownAndCustomerAge(String name, String town, int age);

        List<Customer> findByBookingsCourseNameAndBookingsCourseTown(String name, String town);

        List<Customer> findByBookingsCourseNameAndBookingsCourseTownAndAgeGreaterThan(String name, String town, int age);

        
}
