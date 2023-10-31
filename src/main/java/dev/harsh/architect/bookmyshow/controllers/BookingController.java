package dev.harsh.architect.bookmyshow.controllers;

import dev.harsh.architect.bookmyshow.dtos.request.CreateBookingRequestDto;
import dev.harsh.architect.bookmyshow.models.Booking;
import dev.harsh.architect.bookmyshow.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/booking")
@AllArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody CreateBookingRequestDto createBookingRequestDto){
        return bookingService.createBooking(createBookingRequestDto);
    }

    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable UUID id){
        return bookingService.getBooking(id);
    }

}
