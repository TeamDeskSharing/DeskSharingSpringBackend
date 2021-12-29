package com.example.demo.building;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workplace")
@AllArgsConstructor
public class WorkplaceController {

    @Autowired
    private WorkplaceService workplaceService;


    @GetMapping("/getAllEmployees")
    public List<Workplace> findAllWorkplaces(){
        return workplaceService.getAllWorkplaces();
    }

}
