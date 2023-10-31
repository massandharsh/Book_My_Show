package dev.harsh.architect.bookmyshow.strategies;


import dev.harsh.architect.bookmyshow.enums.SeatType;
import dev.harsh.architect.bookmyshow.models.Booking;

public interface PricingStrategy {
    Double getPrice(Booking booking);
    static double getPriceForSeat(SeatType seatType){
        return switch(seatType){
            case VIP -> 1000;
            case GOLD -> 600;
            case PLATINUM -> 200;
        };
    }
}
