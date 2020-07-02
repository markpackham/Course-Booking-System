package com.example.codeclan.Course.Booking.System.respositories;

import com.example.codeclan.Course.Booking.System.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingRepository extends JpaRepository<Booking, Long> {
}
