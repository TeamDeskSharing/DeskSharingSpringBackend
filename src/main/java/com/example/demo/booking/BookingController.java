package com.example.demo.booking;

import com.example.demo.building.Workplace;
import com.example.demo.employee.Employee;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping("/findBookingsByEmployee/{id}")
    public List<Booking> getBookingsByName(@PathVariable long id) {
        return bookingService.getBookingByEmployee(id);
    }
    @GetMapping("/findBookingsByEmployee/{username}")
    public List<Booking> getBookingByUsername(@PathVariable String username) {
        return bookingService.getBookingByUsername(username);
    }
    @GetMapping("/getWorkplaceByBookingID/{id}")
    public Workplace getWorkplaceByBookingID(@PathVariable long id) {
        return bookingService.getWorkplaceByBookingID(id);
    }
    @GetMapping("/getCurrentPhoneNumberofEmployees")
    public List <Employee> getAllPhoneNumbersofEmployees() {
        return bookingService.getAllPhoneNumbersofEmployees();
    }

    @GetMapping("/findBookingbyID/{id}")
    public Booking getBookingsByName(@PathVariable Long id) {
        return bookingService.getBooking(id);
    }

    @GetMapping("/getCurrentTakenWorksplaces")
    public List<Workplace> getWorkplaceByBookingID() {
        return bookingService.getCurrentTakenWorkplaces();
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
        return bookingService.updateBookingbyIDSetStatusAbgelehnt(id);
    }
    @PutMapping("/updateSchwebend/{id}")
    public Booking updateBookingbyIDSetStatusSchwebend(@PathVariable Long id){
        return bookingService.updateBookingbyIDSetStatusSchwebend(id);
    }

    @PutMapping("/addWorkplaceToBooking/{id}/{wid}")
    public Booking addWorkplaceToBooking(@PathVariable Long id,@PathVariable Long wid){
        return bookingService.addWorkplace(id,wid);
    }

    @PutMapping("/addEmployeeToBooking/{id}/{wid}")
    public Booking addEmployeeToBooking(@PathVariable Long id,@PathVariable Long wid){
        return bookingService.addEmployee(id,wid);
    }

    @PutMapping("/leaveWorkspace/{eid}")
    public Booking leaveWorkspace(@PathVariable Long eid){
        return bookingService.leaveWorkspace(eid);
    }

    @PostMapping("/saveBooking/")
    public Booking saveBooking(@RequestBody Booking booking){
        return bookingService.saveBooking(booking);
    }

    @PostMapping("/saveBookingWithIDs/{user}/{wid}")
    public Booking saveBookingwithids(@RequestBody Booking booking,@PathVariable String user,@PathVariable Long wid){
        return bookingService.saveBookingwithids(booking,user,wid);
    }





}
