package com.example.demo.booking;

import com.example.demo.building.Workplace;
import com.example.demo.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository  extends JpaRepository<Booking, Long> {

List<Booking> findByStatus (String status);
List<Booking> findByEmployee (Employee employee);
List <Booking> findByWorkplace (Workplace workplace);
}
