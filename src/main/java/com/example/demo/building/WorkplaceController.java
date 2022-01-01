package com.example.demo.building;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workplace")
@AllArgsConstructor
public class WorkplaceController {

    @Autowired
    private WorkplaceService workplaceService;


    @GetMapping("/getAllWorkplaces")
    public List<Workplace> findAllWorkplaces(){
        return workplaceService.getAllWorkplaces();
    }

    @PutMapping("/update")
    public Workplace updateEmployee(@RequestBody Workplace workplace){
        return workplaceService.updateWorkplace(workplace);
    }

}
