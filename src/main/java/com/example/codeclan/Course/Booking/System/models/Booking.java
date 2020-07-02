package com.example.codeclan.Course.Booking.System.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="date")
    private String date;

    @JsonBackReference
    @OneToMany(mappedBy = "bookings", fetch = FetchType.LAZY)
    private List<Customer> customers;

    @JsonBackReference
    @OneToMany(mappedBy = "bookings", fetch = FetchType.LAZY)
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
