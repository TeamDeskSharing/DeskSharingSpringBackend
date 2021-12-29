package com.example.demo.booking;

import com.example.demo.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository  extends JpaRepository<Booking, Long> {

    Optional<Booking> findById(Long id);
}
