package com.example.codeclan.Course.Booking.System;

import com.example.codeclan.Course.Booking.System.models.Booking;
import com.example.codeclan.Course.Booking.System.models.Course;
import com.example.codeclan.Course.Booking.System.models.Customer;
import com.example.codeclan.Course.Booking.System.respositories.IBookingRepository;
import com.example.codeclan.Course.Booking.System.respositories.ICourseRepository;
import com.example.codeclan.Course.Booking.System.respositories.ICustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class CourseBookingSystemApplicationTests {

	@Autowired
	IBookingRepository bookingRepository;

	@Autowired
	ICourseRepository courseRepository;

	@Autowired
	ICustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void someTestDataToUse(){
		Customer customer1 = new Customer("alice","aberdeen",10);
		Customer customer2 = new Customer("bob","berwick",20);
		Customer customer3 = new Customer("charles","coatbridge",30);
		Customer customer4 = new Customer("dennis","dundee",40);
		Customer customer5 = new Customer("edgar","edinburgh",50);
		Customer customer6 = new Customer("frank","falkirk",60);

		Course course1 = new Course("algebra","aberdeen",1);
		Course course2 = new Course("biology","berwick",2);
		Course course3 = new Course("chemistry","cardiff",3);

		Booking booking1 = new Booking("01-01-21",course1,customer1);
		Booking booking2 = new Booking("02-02-22",course2,customer2);
		Booking booking3 = new Booking("03-03-23",course3,customer3);
		Booking booking4 = new Booking("01-01-21",course1,customer4);
		Booking booking5 = new Booking("02-02-22",course2,customer5);
		Booking booking6 = new Booking("03-03-23",course3,customer6);
	}

	@Test
	public void canGetRating(){
		List<Course> foundCourses = courseRepository.findByStar(1);
		assertEquals(1,foundCourses.size());
	}

	@Test
	public void canGetAllBookingsForAGivenDate() {
		List<Booking> foundBookings = bookingRepository.findByDate("01-01-21");
		assertEquals(1, foundBookings.size());
	}

	@Test
	public void canGetCustomersForAGivenCourse(){
		List<Customer> foundCustomers = customerRepository.findByBookingsCourseName("algebra");
		assertEquals(1, foundCustomers.size());
	}

	@Test
	public void canGetAllCoursesForAGivenCustomer() {
		List<Course> foundCourses = courseRepository.findByBookingsCustomerName("alice");
		assertEquals(1, foundCourses.size());
	}

	//Get all customers in a given town for a given course

	@Test
	public void canGetAllCustomersInATownForACourse(){
		List<Customer> foundCustomers = customerRepository.findByBookingsCourseNameAndBookingsCourseTown("algebra", "aberdeen");
		assertEquals(1, foundCustomers.size());
	}

	@Test
	public void canGetAllCustomersInATownForACourseAndAgeGreaterThan9() {
		List<Customer> foundCustomers = customerRepository.findByBookingsCourseNameAndBookingsCourseTownAndAgeGreaterThan("algebra", "aberdeen",9);
		assertEquals(1, foundCustomers.size());
	}

}
