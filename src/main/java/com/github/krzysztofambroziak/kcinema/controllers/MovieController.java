package com.github.krzysztofambroziak.kcinema.controllers;

import com.github.krzysztofambroziak.kcinema.dtos.MovieShowtimeDTO;
import com.github.krzysztofambroziak.kcinema.services.MovieService;
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
        return movieService.findMoviesByDate(dateFrom, dateTo);
    }
    
    @GetMapping("/dates/{id:\\d+}")
    List<Calendar> findComingShowtimesForMovieId(@PathVariable Integer id) {
        return movieService.findComingShowtimesForMovieId(id);
    }
    
    private final MovieService movieService;
}
