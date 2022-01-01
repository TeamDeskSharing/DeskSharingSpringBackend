package com.example.demo.building;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Building")
@AllArgsConstructor
public class BuildingController {
    @Autowired
    private BuildingService buildingService;


    @GetMapping("/getAllBuildings")
    public List<Building> findAllBuilding(){
        return buildingService.getAllBuilding();
    }

    @PostMapping("/saveBuilding/{id}")
    public Building addBuilding(@RequestBody Building building){
        return buildingService.saveBuilding(building);
    }
}
