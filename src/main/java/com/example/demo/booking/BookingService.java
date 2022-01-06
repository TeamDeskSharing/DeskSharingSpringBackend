package com.example.demo.booking;

import com.example.demo.building.Workplace;
import com.example.demo.building.WorkplaceRepository;
import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service("api/v1/booking")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)

public class BookingService {

    @Autowired // new
    private final BookingRepository bookingRepository;
    private final WorkplaceRepository workplaceRepository;
    private final EmployeeRepository employeeRepository;



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

    public List<Booking> getBookingByEmployee(long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        return bookingRepository.findByEmployee(employee);
    }

    @GetMapping
    public  List <Employee> getAllPhoneNumbersofEmployees (){

        Date currentDate= new Date();
        List <Employee> employeesInOffice= new ArrayList<>();
        List <Employee> employeesHome = new ArrayList<>();
        List <Employee> employeesAll = employeeRepository.findAll();
        List <Booking> bookings  = bookingRepository.findAll();

        for (int i = 0; i<bookings.size(); i++) {
            System.out.println(i);
            Booking currentBooking = bookings.get(i);
            if (currentBooking.getTimestart().after(currentDate)){
                if (currentBooking.getTimeend().before(currentDate)){
                    Employee employeetmp = currentBooking.getEmployee();
                    employeetmp.setCurrentphonenumber(currentBooking.getWorkplace().getPhone());
                    employeesInOffice.add(employeetmp);
                }
            }else {
                Employee employeetmp = currentBooking.getEmployee();
                try {
                    employeetmp.setCurrentphonenumber(employeetmp.getPhonenumber());
                    employeesHome.add(employeetmp);
                } catch (NullPointerException ioe) {

                }
            }
        }
        employeesInOffice.addAll(employeesHome);
        for (Employee employeeCurrent:employeesAll){
            if(employeesInOffice.contains(employeeCurrent)){
            }else{
                employeesInOffice.add(employeeCurrent);
            }
        }

        return employeesInOffice;
    }

//    @GetMapping
//    public List <Booking> findByEmployeeName(String employeename){
//        return bookingRepository.findByEmployeename(employeename);
//    }



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
        return bookingRepository.save(booking1);
    }

    @PutMapping
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    public Booking updateBookingbyIDSetStatusAkzeptiert(Long id){
        Booking booking1  = bookingRepository.findById(id).orElse(null);
        booking1.setStatus("akzeptiert");
        Employee employee=booking1.getEmployee();
        Mail mail = new Mail ();
        mail.setpName(employee.getFirstname()+" "+employee.getLastname());
        mail.setpStatus("akzeptiert");
        mail.setpMailAdresse(employee.getEmail());
        mail.sendMail();
        return bookingRepository.save(booking1);
    }

    @PutMapping
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    public Booking updateBookingbyIDSetStatusAbgelehnt(Long id){
        Booking booking1  = bookingRepository.findById(id).orElse(null);
        booking1.setStatus("abgelehnt");
        Employee employee=booking1.getEmployee();
        Mail mail = new Mail ();
        mail.setpName(employee.getFirstname()+" "+employee.getLastname());
        mail.setpStatus("abgelehnt");
        mail.setpMailAdresse(employee.getEmail());
        mail.sendMail();
        return bookingRepository.save(booking1);
    }

    @PutMapping
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    public Booking updateBookingbyIDSetStatusSchwebend(Long id){
        Booking booking1  = bookingRepository.findById(id).orElse(null);
        booking1.setStatus("schwebend");
        Employee employee=booking1.getEmployee();
        Mail mail = new Mail ();
        mail.setpName(employee.getFirstname()+" "+employee.getLastname());
        mail.setpStatus("schwebend");
        mail.setText(booking1.getWorkplace().getId().toString());
        mail.setpMailAdresse(employee.getEmail());
        mail.sendMail();
        return bookingRepository.save(booking1);
    }

    @PutMapping
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    public Booking addWorkplace(Long id, long wid){
        Booking booking1  = bookingRepository.findById(id).orElse(null);
        booking1.setWorkplace(workplaceRepository.findById(wid).orElse(null));
        return bookingRepository.save(booking1);
    }

    @PutMapping
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    public Booking addEmployee(Long id, long wid){
        Booking booking1  = bookingRepository.findById(id).orElse(null);
        booking1.setEmployee(employeeRepository.findById(wid).orElse(null));
        return bookingRepository.save(booking1);
    }

    public Booking saveBookingwithids(Booking booking, Long employeeid, Long workplaceid) {
        Booking bookingtmp = booking;
        bookingtmp.setEmployee(employeeRepository.findById(employeeid).orElse(null));
        bookingtmp.setWorkplace(workplaceRepository.findById(workplaceid).orElse(null));
        Date currentDate= new Date();
        if (bookingtmp.getTimeend().before(bookingtmp.getTimestart())){
            System.err.println("Startzeit vor Endzeit");
            return null;
        }
        if (bookingtmp.getTimeend().before(currentDate)&&bookingtmp.getTimestart().before(currentDate)){
            System.err.println("Zeit liegt in der Vergangenheit");
            return null;
        }
        List <Booking> bookinstemp = bookingRepository.findByWorkplace(bookingtmp.getWorkplace());

        for (Booking currentBooking:bookinstemp) {
//            Booking currentBooking= bookinstemp.get(i);
            boolean ueberschneidung = bookingtmp.getTimeend().compareTo(currentBooking.getTimestart()) < 0
                    || currentBooking.getTimeend().compareTo(bookingtmp.getTimeend()) < 0;
            if (ueberschneidung == false){
                System.err.println("Zeit weißt Ueberschneidungen auf");
                return null;
            }
        }
        return bookingRepository.save(bookingtmp);
    }



/*    @Override
    public ResponseEntity<Booking> updateBookingById(Long id, Booking booking){

        Booking myBooking = bookingRepository.findById(id).get();

        myBooking.setStatus(booking.getStatus());


        Booking updatedBooking = bookingRepository.save(myBooking);
        return ResponseEntity.ok(updatedBooking);

    }*/
}
