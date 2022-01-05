package com.example.demo.booking;

import ch.qos.logback.core.html.NOPThrowableRenderer;
import com.example.demo.building.Workplace;
import com.example.demo.employee.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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


    @ManyToOne
    @JoinColumn(name="employeeid", nullable=true)
    private Employee employee=null;

    @ManyToOne
    @JoinColumn(name="workplaceid", nullable=true)
    private Workplace workplace=null;


    public Booking(Long id, Date timestart, Date timeend, String status) {
        this.id = id;
        this.timestart = timestart;
        this.timeend = timeend;
        this.status = status;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        return Objects.equals(id, booking.id) && Objects.equals(timestart, booking.timestart) && Objects.equals(timeend, booking.timeend) && Objects.equals(status, booking.status) && Objects.equals(employee, booking.employee) && Objects.equals(workplace, booking.workplace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestart, timeend, status, employee, workplace);
    }
}
