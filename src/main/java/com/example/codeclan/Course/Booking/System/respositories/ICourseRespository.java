package com.example.codeclan.Course.Booking.System.respositories;

import com.example.codeclan.Course.Booking.System.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRespository extends JpaRepository<Course, Long> {
}
