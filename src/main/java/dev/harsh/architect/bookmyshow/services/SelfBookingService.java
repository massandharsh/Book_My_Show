package dev.harsh.architect.bookmyshow.services;

import dev.harsh.architect.bookmyshow.dtos.request.CreateBookingRequestDto;
import dev.harsh.architect.bookmyshow.dtos.request.CustomerRequestDto;
import dev.harsh.architect.bookmyshow.dtos.response.CustomerResponseDto;
import dev.harsh.architect.bookmyshow.enums.SeatStatus;
import dev.harsh.architect.bookmyshow.exceptions.ShowSeatNotAvailableException;
import dev.harsh.architect.bookmyshow.models.Booking;
import dev.harsh.architect.bookmyshow.models.Customer;
import dev.harsh.architect.bookmyshow.models.Show;
import dev.harsh.architect.bookmyshow.models.ShowSeat;
import dev.harsh.architect.bookmyshow.repositories.BookingRepository;
import dev.harsh.architect.bookmyshow.strategies.PricingStrategy;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Primary
public class SelfBookingService implements BookingService{
    private final CustomerService customerService;
    private final ShowService showService;
    private final SeatShowService seatShowService;
    private final PricingStrategy pricingStrategy;
    private final BookingRepository bookingRepository;
    @Override
    @Transactional
    public Booking createBooking(CreateBookingRequestDto createBookingRequestDto) {
        //Get the customer and validate the customer
        Customer customer = customerService.getCustomerInternal(createBookingRequestDto.getCustomerId());
        if(customer == null){
            //TODO create a custom exception
            throw new RuntimeException("Customer with the given id : " + createBookingRequestDto.getCustomerId() + " does not exist");
        }
        //Get the show and validate the show
        Show show = showService.getShow(createBookingRequestDto.getShowId());
        if(show == null){
            //TODO create a custom exception
            throw new RuntimeException("Show with given id: " + createBookingRequestDto.getShowId() + " does not exist");
        }

        List<ShowSeat> showSeats = saveAndGet(createBookingRequestDto);

        //We have to calculate the amount based

        Booking booking = Booking.builder()
                .customer(customer)
                .show(show)
                .showSeats(showSeats)
                .build();
        double amount = pricingStrategy.getPrice(booking);
        System.out.println(amount);
        return bookingRepository.save(booking.toBuilder().amount(amount).build());


    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @SneakyThrows
    public List<ShowSeat> saveAndGet(CreateBookingRequestDto createBookingRequestDto) {
        //Fetch the show seats and mark the passed ones as locked if available otherwise throw exception
        List<ShowSeat> showSeats = seatShowService.getMultipleShowSeats(createBookingRequestDto.getShowSeatsIds());

        if(!showSeats.stream().allMatch(showSeat -> showSeat.getSeatStatus().equals(SeatStatus.AVAILABLE))){
            throw new ShowSeatNotAvailableException();
        }

        //Marking the show seat status to locked
        showSeats.forEach(showSeat -> showSeat.setSeatStatus(SeatStatus.LOCKED));

        return seatShowService.saveAll(showSeats);

    }

    @Override
    public Booking getBooking(UUID id) {
        return null;
    }
}
