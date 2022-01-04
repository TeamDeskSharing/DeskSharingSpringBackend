package com.example.demo.booking;

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
    public List<Booking> findAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/findBookingsByStatus/{status}")
    public List<Booking> getBookingsByStatus(@PathVariable String status) {
        return bookingService.getBookingByStatus(status);
    }

    @GetMapping("/findBookingsNyName/{name}")
    public List<Booking> getBookingsByName(@PathVariable String name) {
        return bookingService.getBookingByStatus(name);
    }

    @GetMapping("/findBookingbyID/{id}")
    public Booking getBookingsByName(@PathVariable Long id) {
        return bookingService.getBooking(id);
    }

    @PutMapping("/update")
    public Booking updateBooking(@RequestBody Booking booking){
        return bookingService.updateBooking(booking);
    }

    @PutMapping("/update/{id}")
    public Booking updateBookingbyIDSetStatusAkzeptiert(@PathVariable Long id){
        return bookingService.updateBookingbyIDSetStatusAkzeptiert(id);
    }
    @PutMapping("/update/{id}")
    public Booking updateBookingbyIDSetStatusAbgelehnt(@PathVariable Long id){
        return bookingService.updateBookingbyIDSetStatusAkzeptiert(id);
    }
    @PutMapping("/update/{id}")
    public Booking updateBookingbyIDSetStatusSchwebend(@PathVariable Long id){
        return bookingService.updateBookingbyIDSetStatusSchwebend(id);
    }

    @PostMapping("/saveBooking/{id}")
    public Booking addBooking(@RequestBody Booking booking){
        return bookingService.saveBooking(booking);
    }






}
