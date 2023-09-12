package com.github.krzysztofambroziak.kcinema.repositories;

import com.github.krzysztofambroziak.kcinema.entities.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Calendar;
import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Showtime, Integer> {
    List<Showtime> findByDateBetween(Calendar date1, Calendar date2);
}
