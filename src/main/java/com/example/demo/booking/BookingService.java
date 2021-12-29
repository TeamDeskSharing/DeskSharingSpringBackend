package com.example.demo.booking;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service("api/v1/booking")
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
    public Optional<Booking> getBookingID(long id){
        return bookingRepository.findById(id);
    }

    public String deleteEmployee(long id){
        bookingRepository.deleteById(id);
        return "booking deleted";
    }

    public Booking updateBooking(Booking booking){
        Booking booking1  = bookingRepository.findById(booking.getId()).orElse(null);
        booking1.setEndTime(booking.getEndTime());
        booking1.setStatus(booking.getStatus());
        booking1.setStartTime(booking.getStartTime());
        return bookingRepository.save(booking);
    }
}
