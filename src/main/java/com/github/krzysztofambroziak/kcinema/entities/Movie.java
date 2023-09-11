package com.github.krzysztofambroziak.kcinema.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Calendar;
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
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
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
    
    public String getStarring() {
        return starring;
    }
    
    public void setStarring(String starring) {
        this.starring = starring;
    }
    
    public int getDuration() {
        return duration;
    }
    
    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Movie movie = (Movie) o;
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
    
    @Column(name = "description", length = 10000, nullable = false)
    private String description;
    
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar releaseDate;
    
    @Column(name = "director", length = 255, nullable = false)
    private String director;
    
    @Column(name = "starring", length = 255, nullable = false)
    private String starring;
    
    @Column(name = "duration", nullable = false)
    private int duration;
}
