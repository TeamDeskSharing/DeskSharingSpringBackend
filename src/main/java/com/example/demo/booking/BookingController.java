package com.example.demo.booking;

import com.example.demo.employee.Employee;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
@AllArgsConstructor
public class BookingController {

    @Autowired
    private BookingService bookingService;


    @GetMapping("/getAllBookings")
    public List<Booking> findAllBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/findBookings/{status}")
    public List <Booking> getBookingsByStatus(@PathVariable String status){
        return bookingService.getBookingByStatus(status);
    }


}
