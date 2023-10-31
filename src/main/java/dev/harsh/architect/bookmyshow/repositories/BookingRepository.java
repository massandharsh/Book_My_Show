package dev.harsh.architect.bookmyshow.repositories;

import dev.harsh.architect.bookmyshow.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {
}
