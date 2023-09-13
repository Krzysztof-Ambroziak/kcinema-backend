package com.github.krzysztofambroziak.kcinema.controllers;

import com.github.krzysztofambroziak.kcinema.dtos.MovieShowtimeDTO;
import com.github.krzysztofambroziak.kcinema.dtos.ReservationDTO;
import com.github.krzysztofambroziak.kcinema.services.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

@RestController
public class MovieController {
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    
    @GetMapping("/movies/date")
    List<MovieShowtimeDTO> findMoviesByDate(@RequestParam("year") String year,
                                            @RequestParam("month") String month,
                                            @RequestParam("day") String day) {
        final var yyyy = Integer.parseInt(year);
        final var mm = Integer.parseInt(month);
        final var dd = Integer.parseInt(day);
        final var dateFrom = new Calendar.Builder().setCalendarType("gregorian")
                                                   .setDate(yyyy, mm, dd)
                                                   .build();
        final var dateTo = new Calendar.Builder().setCalendarType("gregorian")
                                                 .setDate(yyyy, mm, dd)
                                                 .setTimeOfDay(23, 59, 59)
                                                 .build();
        final var movies = movieService.findMoviesByDate(dateFrom, dateTo);
        if(movies.isEmpty())
            LOGGER.info("No movies found for date: " + day + '-' + month + '-' + year + '.');
        else
            LOGGER.info("Found " + movies.size() + " movies for date: " + day + '-' + month + '-' + year + '.');
        
        return movies;
    }
    
    @GetMapping("/dates/{id:\\d+}")
    List<Calendar> findComingShowtimesForMovieId(@PathVariable Integer id) {
        final var dates = movieService.findComingShowtimesForMovieId(id);
        if(dates.isEmpty())
            LOGGER.info("No showtime found");
        else
            LOGGER.info("Found " + dates.size() + " showtimes.");
        
        return dates;
    }
    
    @GetMapping("/showtime/{id:\\d+}")
    ReservationDTO showArmchairForShowtime(@PathVariable Integer id) {
        LOGGER.info("Request for free armchair was send.");
        
        return movieService.showArmchair(id);
    }
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
    
    private final MovieService movieService;
}
