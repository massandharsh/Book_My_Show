package dev.harsh.architect.bookmyshow.services;

import dev.harsh.architect.bookmyshow.models.ShowSeat;

import java.util.List;
import java.util.UUID;

public interface SeatShowService {
    List<ShowSeat> createShowSeats(List<ShowSeat> showSeats);

    List<ShowSeat> getShowSeats(UUID showId);

    List<ShowSeat> getMultipleShowSeats(List<UUID> showSeatsIds);

    List<ShowSeat> saveAll(List<ShowSeat> showSeats);
}
