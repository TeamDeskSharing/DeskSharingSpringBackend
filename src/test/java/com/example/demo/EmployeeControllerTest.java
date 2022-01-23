package com.example.demo;


import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeControllerTest {

    @Autowired
    EmployeeRepository employeeRepository;
    Employee employee;

    @BeforeEach
    void setUp() {

        employee = new Employee(12L, "hamuddi", "halawi", "hamuddi12", "mohamad.halawi@hs-osnabrueck.de", true, "123");
        employeeRepository.save(employee);

    }

    @Test
    void getEmployeesTest() throws Exception {
        List<Employee> employees = employeeRepository.findAll();
        System.out.println(employees.get(1).getEmail());


    }

}

