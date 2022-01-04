package com.example.demo.booking;

import com.example.demo.building.Workplace;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service("api/v1/booking")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)

public class BookingService {

    @Autowired // new
    private final BookingRepository bookingRepository;



    @GetMapping
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    @PostMapping
    public Booking saveBooking(Booking booking){ //funktioniert auch als list
        return bookingRepository.save(booking);
    }

    @GetMapping
    public Booking getBooking(long id){
        return bookingRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List <Booking> getBookingByStatus(String status){
        return bookingRepository.findByStatus(status);
    }

    @GetMapping
    public  Workplace getWorkplaceByBookingID (long id){
        Booking booking1  = bookingRepository.findById(id).orElse(null);
        return booking1.getWorkplace();
    }

    @GetMapping
    public List <Booking> findByEmployeeName(String employeename){
        return bookingRepository.findByEmployeename(employeename);
    }



    public String deleteEmployee(long id){
        bookingRepository.deleteById(id);
        return "booking deleted";
    }

    @PutMapping
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    public Booking updateBooking(Booking booking){
        Booking booking1  = bookingRepository.findById(booking.getId()).orElse(null);
        booking1.setTimeend(booking.getTimeend());
        booking1.setStatus(booking.getStatus());
        booking1.setTimestart(booking.getTimestart());
        booking1.setEmployeename(booking.getEmployeename());
        return bookingRepository.save(booking1);
    }

    @PutMapping
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    public Booking updateBookingbyIDSetStatusAkzeptiert(Long id){
        Booking booking1  = bookingRepository.findById(id).orElse(null);
        booking1.setStatus("akzeptiert");
        return bookingRepository.save(booking1);
    }

    @PutMapping
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    public Booking updateBookingbyIDSetStatusAbgelehnt(Long id){
        Booking booking1  = bookingRepository.findById(id).orElse(null);
        booking1.setStatus("abgelehnt");
        return bookingRepository.save(booking1);
    }

    @PutMapping
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    public Booking updateBookingbyIDSetStatusSchwebend(Long id){
        Booking booking1  = bookingRepository.findById(id).orElse(null);
        booking1.setStatus("schwebend");
        return bookingRepository.save(booking1);
    }

    @PutMapping
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    public Booking addWorkplace(Long id, Workplace workplace){
        Booking booking1  = bookingRepository.findById(id).orElse(null);
        booking1.setWorkplace(workplace);
        return bookingRepository.save(booking1);
    }


/*    @Override
    public ResponseEntity<Booking> updateBookingById(Long id, Booking booking){

        Booking myBooking = bookingRepository.findById(id).get();

        myBooking.setStatus(booking.getStatus());


        Booking updatedBooking = bookingRepository.save(myBooking);
        return ResponseEntity.ok(updatedBooking);

    }*/
}
