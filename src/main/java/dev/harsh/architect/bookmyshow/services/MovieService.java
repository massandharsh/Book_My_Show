package dev.harsh.architect.bookmyshow.services;

import dev.harsh.architect.bookmyshow.models.Movie;

import java.util.UUID;

public interface MovieService {

    Movie getMovie(UUID id);

    Movie createMovie(Movie movie);
}
