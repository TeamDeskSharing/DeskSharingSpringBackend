package com.example.demo.booking;

import com.example.demo.building.Building;
import com.example.demo.employee.Employee;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findBookingsByStatus/{status}")
    public List <Booking> getBookingsByStatus(@PathVariable String status){
        return bookingService.getBookingByStatus(status);
    }

    @GetMapping("/findBookingById/{id}")
    public Booking getBookingById(@PathVariable Long id){
        return bookingService.getBooking(id);
    }

    @GetMapping("/findBookingsByName/{employeeName}")
    public List <Booking> getBookingsByName(@PathVariable String employeeName){
        return bookingService.getBookingByStatus(employeeName);
    }

    @PutMapping("/update")
    public Booking updateBooking(@RequestBody Booking booking){
        return bookingService.updateBooking(booking);
    }

    @PostMapping("/saveBooking/{id}")
    public Booking addBooking(@RequestBody Booking booking){
        return bookingService.saveBooking(booking);
    }

}
