package com.example.demo.employee;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/Employees")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)

public class EmployeeManagementController {

    private static final List<Employee> EMPLOYEES = Arrays.asList(
            new Employee(1L, "James", "Employee","Employee"),
            new Employee(2L, "Maria", "Employee","Employee"),
            new Employee(3L, "Anna", "Employee","Employee")
    );

//    hasRole('ROLE_') hasAnyRole('ROLE_') hasAuthority('permission') hasAnyAuthority('permission')

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    public List<Employee> getAllEmployees() {
        System.out.println("getAllEmployees");
        return EMPLOYEES;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('Employee:write')")
    public void registerNewEmployee(@RequestBody Employee Employee) {
        System.out.println("registerNewEmployee");
        System.out.println(Employee);
    }

    @DeleteMapping(path = "{EmployeeId}")
    @PreAuthorize("hasAuthority('Employee:write')")
    public void deleteEmployee(@PathVariable("EmployeeId") Integer id) {
        System.out.println("deleteEmployee");
        System.out.println(id);
    }

    @PutMapping(path = "{EmployeeId}")
    @PreAuthorize("hasAuthority('Employee:write')")
    public void updateEmployee(@PathVariable("EmployeeId") Integer id, @RequestBody Employee Employee) {
        System.out.println("updateEmployee");
        System.out.println(String.format("%s %s", id, Employee));
    }
}
