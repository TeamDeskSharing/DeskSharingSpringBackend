package com.example.demo;


import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

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

