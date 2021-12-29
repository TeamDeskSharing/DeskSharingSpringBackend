package com.example.demo.building;

import com.example.demo.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, Long> {

    Office findByDescription(String description);
}
