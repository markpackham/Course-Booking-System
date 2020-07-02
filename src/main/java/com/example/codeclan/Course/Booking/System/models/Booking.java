package com.example.codeclan.Course.Booking.System.models;

import java.util.ArrayList;
import java.util.List;

public class Booking {

    private Long id;
    private String date;
    private List<Customer> customers;
    private List<Course> courses;

    public Booking(String date) {
        this.date = date;
        this.customers = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public Booking(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
