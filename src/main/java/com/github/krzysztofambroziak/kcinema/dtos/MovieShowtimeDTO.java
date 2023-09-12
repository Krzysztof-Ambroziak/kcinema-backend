package com.github.krzysztofambroziak.kcinema.dtos;

import java.io.Serializable;
import java.util.Calendar;

public class MovieShowtimeDTO implements Serializable {
    public MovieDTO getMovieDTO() {
        return movieDTO;
    }
    
    public void setMovieDTO(MovieDTO movieDTO) {
        this.movieDTO = movieDTO;
    }
    
    public Calendar getShowtime() {
        return showtime;
    }
    
    public void setShowtime(Calendar showtime) {
        this.showtime = showtime;
    }
    
    private MovieDTO movieDTO;
    
    private Calendar showtime;
}
