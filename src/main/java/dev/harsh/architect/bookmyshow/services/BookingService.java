package dev.harsh.architect.bookmyshow.services;

import dev.harsh.architect.bookmyshow.dtos.request.CreateBookingRequestDto;
import dev.harsh.architect.bookmyshow.models.Booking;

import java.util.UUID;

public interface BookingService {
    Booking createBooking(CreateBookingRequestDto createBookingRequestDto);

    Booking getBooking(UUID id);
}
