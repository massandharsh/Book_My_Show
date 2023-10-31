package dev.harsh.architect.bookmyshow.controllers;

import dev.harsh.architect.bookmyshow.dtos.request.CreateMovieRequestDto;
import dev.harsh.architect.bookmyshow.dtos.request.ShowRequestDto;
import dev.harsh.architect.bookmyshow.models.Movie;
import dev.harsh.architect.bookmyshow.models.Show;
import dev.harsh.architect.bookmyshow.services.MovieService;
import dev.harsh.architect.bookmyshow.services.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/show")
public class ShowController {
    private final ShowService showService;

    //Create show
    @PostMapping
    public Show createShow(@RequestBody ShowRequestDto showRequestDto){
        return showService.createShow(showRequestDto);
    }

    @GetMapping("/{id}")
    public Show getShow(@PathVariable UUID id){
        return showService.getShow(id);
    }


}
