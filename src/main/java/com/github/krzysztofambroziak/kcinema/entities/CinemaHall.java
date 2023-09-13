package com.github.krzysztofambroziak.kcinema.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "rooms")
public class CinemaHall {
    public CinemaHall() {
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNumber() {
        return number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }
    
    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        CinemaHall cinemaHall = (CinemaHall)o;
        return Objects.equals(id, cinemaHall.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "number", length = 10, nullable = false)
    private String number;
    
    @OneToMany
    @JoinColumn(name = "room_id")
    List<Seat> seats;
}
