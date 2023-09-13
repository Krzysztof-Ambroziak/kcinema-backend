package com.github.krzysztofambroziak.kcinema.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "showtimes")
public class Showtime {
    public Showtime() {
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Calendar getDate() {
        return date;
    }
    
    public void setDate(Calendar date) {
        this.date = date;
    }
    
    public Movie getMovie() {
        return movie;
    }
    
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    public List<Seat> getSeat() {
        return seat;
    }
    
    public void setSeat(List<Seat> seat) {
        this.seat = seat;
    }
    
    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Showtime showtime = (Showtime)o;
        return Objects.equals(id, showtime.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar date;
    
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    
    @ManyToMany(mappedBy = "showtimes")
    private List<Seat> seat;
}
