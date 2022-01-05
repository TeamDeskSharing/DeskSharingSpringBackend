package com.example.demo.booking;

import com.example.demo.building.Workplace;
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

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "booking_sequence"
    )
    @Id
    private Long id;

    private Date timestart;
    private Date timeend;
    private String status;
    private String employeename;

    @ManyToOne
    @JoinColumn(name="workplace_id", nullable=true)
    private Workplace workplace;


    public Booking(Long id, Date timestart, Date timeend, String status, String employeename) {
        this.id = id;
        this.timestart = timestart;
        this.timeend = timeend;
        this.status = status;
        this.employeename = employeename;
    }

    //@Id

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

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public Workplace getWorkplace() {
        return workplace;
    }

    public void setWorkplace(Workplace workplace) {
        this.workplace = workplace;
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
