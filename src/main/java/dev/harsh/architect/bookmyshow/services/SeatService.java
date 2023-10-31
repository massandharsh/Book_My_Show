package dev.harsh.architect.bookmyshow.services;

import dev.harsh.architect.bookmyshow.models.Seat;

import java.util.List;
import java.util.UUID;

public interface SeatService {
    List<Seat> getSeatsInternal(UUID hallId);

    List<Seat> createSeats(List<Seat> seats);
}
