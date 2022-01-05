package com.example.demo.building;

import com.example.demo.booking.Booking;
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

    @GetMapping("/getAllWorkplaces/{id}")
    public Workplace findAWorkplaceByID(@PathVariable Long id){
        return workplaceService.getWorkplace(id);
    }

//    @GetMapping("/getAllBookingsOfWorkplace/{id}")
//    public List <Booking> getAllBookingsOfWorkplace(@PathVariable Long id){
//        return workplaceService.getAllBookingsOfWorkplace(id);
//    }


    @PutMapping("/update")
    public Workplace updateWorkplace(@RequestBody Workplace workplace){
        return workplaceService.updateWorkplace(workplace);
    }

    @PutMapping("/addBooking/{id}")
    public Workplace updateEmployee(@PathVariable Long id,@RequestBody Booking booking){
        return workplaceService.addBooking(id,booking);
    }

}
