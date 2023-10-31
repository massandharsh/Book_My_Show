package dev.harsh.architect.bookmyshow.controllers;

import dev.harsh.architect.bookmyshow.dtos.request.CreateHallRequestDto;
import dev.harsh.architect.bookmyshow.models.Hall;
import dev.harsh.architect.bookmyshow.services.HallService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/hall")
public class HallController {
    private final HallService hallService;

    @GetMapping("/{id}")
    public Hall getHall(@PathVariable UUID id){
        return hallService.getHall(id);
    }

    @PostMapping
    public Hall createHall(@RequestBody CreateHallRequestDto createHallRequestDto){
        return hallService.createHall(createHallRequestDto);
    }
}
