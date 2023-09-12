package com.github.krzysztofambroziak.kcinema.dtos;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

public class MovieDTO implements Serializable {
    public static class Builder {
        public MovieDTO.Builder setTitle(String title) {
            this.title = title;
            return this;
        }
        
        public MovieDTO.Builder setStoryline(String storyline) {
            this.storyline = storyline;
            return this;
        }
        
        public MovieDTO.Builder setReleaseDate(Calendar releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }
        
        public MovieDTO.Builder setDirectors(List<String> directors) {
            this.directors = directors;
            return this;
        }
        
        public MovieDTO.Builder addDirector(String director) {
            directors.add(director);
            return this;
        }
        
        public MovieDTO.Builder setCast(List<String> cast) {
            this.cast = cast;
            return this;
        }
        
        public MovieDTO.Builder addStar(String star) {
            cast.add(star);
            return this;
        }
        
        public MovieDTO.Builder setDuration(int duration) {
            this.duration = duration;
            return this;
        }
        
        public MovieDTO build() {
            return new MovieDTO(this);
        }
        
        private String title;
        private String storyline;
        private Calendar releaseDate;
        private List<String> directors;
        private List<String> cast;
        private int duration;
    }
    
    private MovieDTO(Builder builder) {
        title = builder.title;
        storyline = builder.storyline;
        releaseDate = builder.releaseDate;
        directors = builder.directors;
        cast = builder.cast;
        duration = builder.duration;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getStoryline() {
        return storyline;
    }
    
    public Calendar getReleaseDate() {
        return releaseDate;
    }
    
    public List<String> getDirectors() {
        return directors;
    }
    
    public List<String> getCast() {
        return cast;
    }
    
    public int getDuration() {
        return duration;
    }
    
    private final String title;
    
    private final String storyline;
    
    private final Calendar releaseDate;
    
    private final List<String> directors;
    
    private final List<String> cast;
    
    private final int duration;
}
