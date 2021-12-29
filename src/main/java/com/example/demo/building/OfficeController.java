package com.example.demo.building;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Office")
@AllArgsConstructor
public class OfficeController {

    @Autowired
    private OfficeService officeService;


    @GetMapping("/getAllOffices")
    public List<Office> findAllEmployees(){
        return officeService.getAllOffice();
    }
}
