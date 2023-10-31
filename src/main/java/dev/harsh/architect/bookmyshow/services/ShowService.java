package dev.harsh.architect.bookmyshow.services;

import dev.harsh.architect.bookmyshow.dtos.request.ShowRequestDto;
import dev.harsh.architect.bookmyshow.models.Show;

import java.util.UUID;

public interface ShowService {
    Show createShow(ShowRequestDto showRequestDto);

    Show getShow(UUID id);
}
