package com.example.demo.booking;

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

    private Date timestart;
    private Date timeend;
    private String status;
    private String employeename;
    private String workplace;

    public Booking(Long id, Date timestart, Date timeend, String status, String employeename, String workplace) {
        this.id = id;
        this.timestart = timestart;
        this.timeend = timeend;
        this.status = status;
        this.employeename = employeename;
        this.workplace = workplace;
    }

    @Id

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getTimestart() {
        return timestart;
    }

    public void setTimestart(Date timestart) {
        this.timestart = timestart;
    }

    public Date getTimeend() {
        return timeend;
    }

    public void setTimeend(Date timeend) {
        this.timeend = timeend;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
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
        return Objects.equals(id, booking.id) && Objects.equals(timestart, booking.timestart) && Objects.equals(timeend, booking.timeend) && Objects.equals(status, booking.status) && Objects.equals(employeename, booking.employeename) && Objects.equals(workplace, booking.workplace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestart, timeend, status, employeename, workplace);
    }
}
