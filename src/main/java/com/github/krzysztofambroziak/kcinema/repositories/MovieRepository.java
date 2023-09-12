package com.github.krzysztofambroziak.kcinema.repositories;

import com.github.krzysztofambroziak.kcinema.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
