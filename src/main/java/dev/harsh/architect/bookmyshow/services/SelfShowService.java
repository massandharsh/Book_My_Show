package dev.harsh.architect.bookmyshow.services;

import dev.harsh.architect.bookmyshow.dtos.request.ShowRequestDto;
import dev.harsh.architect.bookmyshow.enums.SeatStatus;
import dev.harsh.architect.bookmyshow.exceptions.ShowDoesNotExistException;
import dev.harsh.architect.bookmyshow.models.*;
import dev.harsh.architect.bookmyshow.repositories.ShowRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("selfShowImpl")
@AllArgsConstructor
@Primary
public class SelfShowService implements ShowService {
    private final ShowRepository showRepository;
    private final MovieService movieService;
    private final HallService hallService;
    private final SeatService seatService;
    private final SeatShowService seatShowService;

    @Override
    public Show createShow(ShowRequestDto showRequestDto) {
        Hall hall = hallService.getHallInternal(showRequestDto.getHallId());
        if(hall == null){
            //TODO create a class for exception
            throw new RuntimeException("Hall does not exist");
        }
        Movie movie = movieService.getMovie(showRequestDto.getMovieId());
        if(movie == null){
            //TODO create a custom exception for Movie
            throw new RuntimeException("Movie does not exist");
        }
        List<Seat> seats = seatService.getSeatsInternal(showRequestDto.getHallId());
        Show show = Show.builder()
                .duration(showRequestDto.getDuration())
                .feature(showRequestDto.getFeature())
                .language(showRequestDto.getLanguage())
                .hall(hall)
                .movie(movie)
                .build();

        Show persistedShow = showRepository.save(show);

        List<ShowSeat> showSeats = seats.stream().map(seat -> ShowSeat.builder().show(persistedShow).seat(seat).build()).toList();

        //We have to persist many side first in many one relation as it will have a reference id

        List<ShowSeat> showSeat = seatShowService.createShowSeats(showSeats);

        return showRepository.save(persistedShow.toBuilder().seats(showSeat).build());

    }

    @Override
    public Show getShow(UUID id) {
        return showRepository.findById(id)
                .orElseThrow(()-> new ShowDoesNotExistException(id));
    }
}
