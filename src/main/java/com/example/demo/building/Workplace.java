package com.example.demo.building;

import com.example.demo.booking.Booking;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "t_workplace")


public class Workplace {
    @SequenceGenerator(
            name = "workplace_sequence",
            sequenceName = "workplace_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "workplace_sequence"
    )
    private Long id;

    private String phone;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Booking> bookings = new ArrayList<>();

    public Workplace(Long id, String phone) {
        this.id = id;
        this.phone = phone;
    }
    @Id

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workplace workplace = (Workplace) o;
        return Objects.equals(id, workplace.id) && Objects.equals(phone, workplace.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone);
    }
}
