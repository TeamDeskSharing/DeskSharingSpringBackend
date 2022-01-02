package com.example.demo.booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "t_booking")
public class Booking {

    @SequenceGenerator(
            name = "booking_sequence",
            sequenceName = "booking_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "booking_sequence"
    )
    private Long id;

    private Date starttime;
    private Date endtime;
    private String status;
    private String employeename;

    public Booking(Long id, Date starttime, Date endtime, String status, String employeename) {
        this.id = id;
        this.starttime = starttime;
        this.endtime = endtime;
        this.status = status;
        this.employeename = employeename;
    }

    /*    public Booking(Long id, Date startTime, Date endTime, String status,String employeeName) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.employeeName = employeeName;
    }*/

    @Id

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) && Objects.equals(starttime, booking.starttime) && Objects.equals(endtime, booking.endtime) && Objects.equals(status, booking.status) && Objects.equals(employeename, booking.employeename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, starttime, endtime, status, employeename);
    }
}
