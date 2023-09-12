package com.github.krzysztofambroziak.kcinema.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "movies")
public class Movie {
    public Movie() {
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getStoryline() {
        return storyline;
    }
    
    public void setStoryline(String storyline) {
        this.storyline = storyline;
    }
    
    public Calendar getReleaseDate() {
        return releaseDate;
    }
    
    public void setReleaseDate(Calendar releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public String getDirector() {
        return director;
    }
    
    public void setDirector(String director) {
        this.director = director;
    }
    
    public String getCast() {
        return cast;
    }
    
    public void setCast(String starring) {
        this.cast = cast;
    }
    
    public int getDuration() {
        return duration;
    }
    
    public void setDuration(int duration) {
        this.duration = duration;
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
        Movie movie = (Movie)o;
        return Objects.equals(id, movie.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "title", length = 255, nullable = false)
    private String title;
    
    @Column(name = "storyline", length = 10000, nullable = false)
    private String storyline;
    
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar releaseDate;
    
    @Column(name = "director", length = 255, nullable = false)
    private String director;
    
    @Column(name = "cast", length = 255, nullable = false)
    private String cast;
    
    @Column(name = "duration", nullable = false)
    private int duration;
    
    @OneToMany(mappedBy = "movie")
    List<Showtime> showtimes;
}
