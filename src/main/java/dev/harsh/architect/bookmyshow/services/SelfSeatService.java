package dev.harsh.architect.bookmyshow.services;

import dev.harsh.architect.bookmyshow.models.Seat;
import dev.harsh.architect.bookmyshow.repositories.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("selfSeatService")
@AllArgsConstructor
@Primary
public class SelfSeatService implements SeatService{
    private final SeatRepository seatRepository;

    @Override
    public List<Seat> getSeatsInternal(UUID hallId) {
        return seatRepository.findAllByHall_Uuid(hallId);
    }

    @Override
    public List<Seat> createSeats(List<Seat> seats) {
        return seatRepository.saveAll(seats);
    }
}
