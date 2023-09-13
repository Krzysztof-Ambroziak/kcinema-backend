package com.github.krzysztofambroziak.kcinema.services;

import com.github.krzysztofambroziak.kcinema.dtos.MovieDTO;
import com.github.krzysztofambroziak.kcinema.dtos.MovieShowtimeDTO;
import com.github.krzysztofambroziak.kcinema.dtos.ReservationDTO;
import com.github.krzysztofambroziak.kcinema.dtos.ReservationType;
import com.github.krzysztofambroziak.kcinema.dtos.SeatDTO;
import com.github.krzysztofambroziak.kcinema.entities.Showtime;
import com.github.krzysztofambroziak.kcinema.repositories.MovieRepository;
import com.github.krzysztofambroziak.kcinema.repositories.ShowtimeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    public MovieService(ShowtimeRepository showtimeRepository, MovieRepository movieRepository) {
        this.showtimeRepository = showtimeRepository;
        this.movieRepository = movieRepository;
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
    
    public List<Calendar> findComingShowtimesForMovieId(Integer id) {
        final var movie = movieRepository.findById(id);
        
        return movie.map(o -> o.getShowtimes()
                               .stream()
                               .map(Showtime::getDate)
                               .filter(calendar -> calendar.after(Calendar.getInstance()))
                               .collect(Collectors.toList()))
                    .orElseGet(ArrayList::new);
    }
    
    public ReservationDTO showArmchair(Integer id) {
        final var showtime = showtimeRepository.findById(id);
        var reservationDTO = new ReservationDTO();
        
        if(showtime.isPresent()) {
            final var st = showtime.get();
            final var reservedSeat = st.getSeats();
            
            for(final var seat : st.getCinemaHall().getSeats()) {
                var seatDTO = new SeatDTO(seat.getRow(), seat.getNumber(), ReservationType.FREE);
                
                if(reservedSeat.contains(seat))
                    seatDTO.setReservationType(ReservationType.RESERVED);
                reservationDTO.addSeat(seatDTO);
            }
        }
        
        return reservationDTO;
    }
    
    private final ShowtimeRepository showtimeRepository;
    
    private final MovieRepository movieRepository;
}
