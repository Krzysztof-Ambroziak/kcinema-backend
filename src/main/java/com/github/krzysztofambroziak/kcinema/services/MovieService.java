package com.github.krzysztofambroziak.kcinema.services;

import com.github.krzysztofambroziak.kcinema.dtos.MovieDTO;
import com.github.krzysztofambroziak.kcinema.dtos.MovieShowtimeDTO;
import com.github.krzysztofambroziak.kcinema.entities.Showtime;
import com.github.krzysztofambroziak.kcinema.repositories.ShowtimeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class MovieService {
    public MovieService(ShowtimeRepository showtimeRepository) {
        this.showtimeRepository = showtimeRepository;
    }
    
    public List<MovieShowtimeDTO> findMoviesByDate(Calendar dateFrom, Calendar dateTo) {
        List<Showtime> showtimes = showtimeRepository.findByDateBetween(dateFrom, dateTo);
        List<MovieShowtimeDTO> movieShowtimeDTOS = new ArrayList<>();
        
        for(final var showtime : showtimes) {
            final var movie = showtime.getMovie();
            final var date = showtime.getDate();
            final var movieDTO = new MovieDTO.Builder().setTitle(movie.getTitle())
                                                       .setDuration(movie.getDuration())
                                                       .build();
            var movieShowtimeDTO = new MovieShowtimeDTO();
            
            movieShowtimeDTO.setMovieDTO(movieDTO);
            movieShowtimeDTO.setShowtime(date);
            movieShowtimeDTOS.add(movieShowtimeDTO);
        }
        
        return movieShowtimeDTOS;
    }
    
    private final ShowtimeRepository showtimeRepository;
}
