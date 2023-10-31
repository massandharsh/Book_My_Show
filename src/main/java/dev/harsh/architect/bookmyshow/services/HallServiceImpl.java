package dev.harsh.architect.bookmyshow.services;

import dev.harsh.architect.bookmyshow.dtos.request.CreateHallRequestDto;
import dev.harsh.architect.bookmyshow.dtos.request.CreateSeatRequestDto;
import dev.harsh.architect.bookmyshow.models.Hall;
import dev.harsh.architect.bookmyshow.models.Seat;
import dev.harsh.architect.bookmyshow.repositories.HallRepository;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("selfHallServiceImpl")
@Primary
@AllArgsConstructor
public class HallServiceImpl implements HallService{
    private final HallRepository hallRepository;
    private final SeatService seatService;
    @Override
    public Hall getHallInternal(UUID hallId) {
        return hallRepository.findById(hallId)
                .orElse(null);
    }

    @Override
    public Hall getHall(UUID id) {
        //TODO create a custom exception
        return hallRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Hall with id : " + id + " does not exist"));
    }

    @Override
    public Hall createHall(CreateHallRequestDto createHallRequestDto) {

        //Create the seats based on the request
        List<Seat> persistedSeats = seatService.createSeats(getSeats(createHallRequestDto));

        //Create a hall based on persisted seats

        Hall hall = Hall.builder()
                .seats(persistedSeats)
                .hallNumber(createHallRequestDto.getHallNumber())
                .features(createHallRequestDto.getFeatures())
                .build();


        //Persist the hall
        Hall persistedHall =  hallRepository.save(hall);
        persistedSeats.forEach(seat-> seat.setHall(persistedHall));

        seatService.createSeats(persistedSeats);
        return persistedHall;
    }

    @NotNull
    private static List<Seat> getSeats(CreateHallRequestDto createHallRequestDto) {
        List<CreateSeatRequestDto> createSeatRequestDtoList = createHallRequestDto.getSeatRequest();
        //Create the seats and persist it
        return createSeatRequestDtoList.stream()
                .map(createSeatRequestDto -> Seat.builder()
                        .seatType(createSeatRequestDto.getSeatType())
                        .rowNo(createSeatRequestDto.getRow())
                        .colNo(createSeatRequestDto.getCol())
                        .build()
                ).toList();
    }
}
