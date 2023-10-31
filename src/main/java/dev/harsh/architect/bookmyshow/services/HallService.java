package dev.harsh.architect.bookmyshow.services;

import dev.harsh.architect.bookmyshow.dtos.request.CreateHallRequestDto;
import dev.harsh.architect.bookmyshow.models.Hall;

import java.util.UUID;

public interface HallService {
    Hall getHallInternal(UUID hallId);

    Hall getHall(UUID id);

    Hall createHall(CreateHallRequestDto createHallRequestDto);
}
