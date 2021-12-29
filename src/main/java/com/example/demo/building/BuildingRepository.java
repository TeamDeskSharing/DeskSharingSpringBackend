package com.example.demo.building;

import com.example.demo.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository  extends JpaRepository<Building, Long> {
    Building findByDescription(String description);
}
