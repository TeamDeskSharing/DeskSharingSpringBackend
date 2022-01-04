package com.example.demo.booking;

import com.example.demo.building.Workplace;
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

    @GetMapping("/getWorkplaceByBookingID/{id}")
    public Workplace getWorkplaceByBookingID(@PathVariable long id) {
        return bookingService.getWorkplaceByBookingID(id);
    }

    @GetMapping("/findBookingbyID/{id}")
    public Booking getBookingsByName(@PathVariable Long id) {
        return bookingService.getBooking(id);
    }

    @PutMapping("/update")
    public Booking updateBooking(@RequestBody Booking booking){
        return bookingService.updateBooking(booking);
    }

    @PutMapping("/updateAkzeptiert/{id}")
    public Booking updateBookingbyIDSetStatusAkzeptiert(@PathVariable Long id){
        return bookingService.updateBookingbyIDSetStatusAkzeptiert(id);
    }
    @PutMapping("/updateAbgelehnt/{id}")
    public Booking updateBookingbyIDSetStatusAbgelehnt(@PathVariable Long id){
        return bookingService.updateBookingbyIDSetStatusAkzeptiert(id);
    }
    @PutMapping("/updateSchwebend/{id}")
    public Booking updateBookingbyIDSetStatusSchwebend(@PathVariable Long id){
        return bookingService.updateBookingbyIDSetStatusSchwebend(id);
    }

    @PutMapping("/addWorkplaceToBooking/{id}")
    public Booking addWorkplaceToBooking(@PathVariable Long id,@RequestBody Workplace workplace){
        return bookingService.addWorkplace(id,workplace);
    }

    @PostMapping("/saveBooking/{id}")
    public Booking saveBooking(@RequestBody Booking booking){
        return bookingService.saveBooking(booking);
    }






}
