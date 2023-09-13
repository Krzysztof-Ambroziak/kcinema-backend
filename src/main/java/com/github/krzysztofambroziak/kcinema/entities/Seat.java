package com.github.krzysztofambroziak.kcinema.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "seats")
public class Seat {
    Seat() {
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public int getRow() {
        return row;
    }
    
    public void setRow(int row) {
        this.row = row;
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    public List<Showtime> getShowtimes() {
        return showtimes;
    }
    
    public void setShowtimes(List<Showtime> showtimes) {
        this.showtimes = showtimes;
    }
    
    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Seat seat = (Seat)o;
        return Objects.equals(id, seat.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    // `row` zamiast row bo błąd składni
    @Column(name = "`row`", nullable = false)
    private int row;
    
    @Column(name = "num", nullable = false)
    private int number;
    
    @ManyToMany
    @JoinTable(name = "reservations")
    private List<Showtime> showtimes;
}
