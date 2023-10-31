package dev.harsh.architect.bookmyshow.controllers;


import dev.harsh.architect.bookmyshow.dtos.request.CreateMovieRequestDto;
import dev.harsh.architect.bookmyshow.models.Movie;
import dev.harsh.architect.bookmyshow.services.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/movie/{id}")
    public Movie getMovie(@PathVariable UUID id){
        return movieService.getMovie(id);
    }

    @PostMapping
    public Movie createMovie(@RequestBody CreateMovieRequestDto requestDto){
        return movieService.createMovie(requestDto.toMovie());
    }
}
