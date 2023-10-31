package dev.harsh.architect.bookmyshow.services;

import dev.harsh.architect.bookmyshow.models.ShowSeat;
import dev.harsh.architect.bookmyshow.repositories.ShowSeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Primary
@AllArgsConstructor
public class ShowSeatServiceImpl implements SeatShowService{
    private final ShowSeatRepository showSeatRepository;
    @Override
    public List<ShowSeat> createShowSeats(List<ShowSeat> showSeats) {
        return showSeatRepository.saveAll(showSeats);
    }

    @Override
    public List<ShowSeat> getShowSeats(UUID showId) {
        return showSeatRepository.findAllByShow_Uuid(showId);
    }

    @Override
    public List<ShowSeat> getMultipleShowSeats(List<UUID> showSeatsIds) {
        return showSeatRepository.findAllByUuidIn(showSeatsIds);
    }

    @Override
    public List<ShowSeat> saveAll(List<ShowSeat> showSeats) {
        return showSeatRepository.saveAll(showSeats);
    }
}
