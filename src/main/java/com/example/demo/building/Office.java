package com.example.demo.building;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "t_office")
public class Office {

    @SequenceGenerator(
            name = "office_sequence",
            sequenceName = "office_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "office_sequence"
    )
    private Long id;

    private String description;

    public Office(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    @Id

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return Objects.equals(id, office.id) && Objects.equals(description, office.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}
