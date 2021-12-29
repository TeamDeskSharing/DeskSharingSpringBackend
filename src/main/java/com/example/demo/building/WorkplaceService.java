package com.example.demo.building;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@AllArgsConstructor
@Service("api/v1/workplaces")
public class WorkplaceService {

    @Autowired // new
    private final WorkplaceRepository workplaceRepository;

    @GetMapping
    public List<Workplace> getAllWorkplaces(){
        return workplaceRepository.findAll();
    }

    @PostMapping
    public Workplace saveWorkplace(Workplace workplace){ //funktioniert auch als list
        return workplaceRepository.save(workplace);
    }

    @GetMapping
    public Workplace getWorkplace(long id){
        return workplaceRepository.findById(id).orElse(null);
    }

    @GetMapping
    public Workplace getWorkplaceByPhone(String phone){
        return workplaceRepository.findByphone(phone);
    }

    public String deleteEmployee(long id){
        workplaceRepository.deleteById(id);
        return "workplace deleted";
    }

    public Workplace updateWorkplace(Workplace workplace){
        Workplace workplace1  = workplaceRepository.findById(workplace.getId()).orElse(null);
        workplace1.setPhone(workplace.getPhone());
        return workplaceRepository.save(workplace1);
    }
}
