package dev.harsh.architect.bookmyshow.strategies;

import dev.harsh.architect.bookmyshow.models.Booking;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@Primary
public class SeatBasedPricingStrategy implements PricingStrategy{

    @Override
    public Double getPrice(Booking booking) {
        return booking.getShowSeats().stream().mapToDouble(showSeat -> PricingStrategy.getPriceForSeat(showSeat.getSeat().getSeatType()))
                .sum();
    }
}
