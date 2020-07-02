package com.example.codeclan.Course.Booking.System.models;

public class Course {
    private Long id;
    private String name;
    private String town;
    private int star;

    public Course(String name, String town, int star) {
        this.name = name;
        this.town = town;
        this.star = star;
    }

    public Course(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
