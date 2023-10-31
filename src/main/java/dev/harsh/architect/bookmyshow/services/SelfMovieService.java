package dev.harsh.architect.bookmyshow.services;


import dev.harsh.architect.bookmyshow.exceptions.MovieAlreadyExistException;
import dev.harsh.architect.bookmyshow.exceptions.MovieDoesNotExistException;
import dev.harsh.architect.bookmyshow.models.Movie;
import dev.harsh.architect.bookmyshow.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service("selfMovieService")
@AllArgsConstructor
@Primary
public class SelfMovieService implements MovieService{

    private MovieRepository movieRepository;
    @Override
    public Movie getMovie(UUID id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieDoesNotExistException(id));
    }

    @Override
    public Movie createMovie(Movie movie) {
        //If movie with the name already exists throw the exception
        movieRepository.findByName(movie.getName())
                .ifPresent(movie1 ->{
                    throw new MovieAlreadyExistException(movie.getName());
                });

        return movieRepository.save(movie);
    }
}
