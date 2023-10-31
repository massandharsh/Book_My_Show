package dev.harsh.architect.bookmyshow.repositories;

import dev.harsh.architect.bookmyshow.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SeatRepository extends JpaRepository<Seat, UUID> {
    List<Seat> findAllByHall_Uuid(UUID id);

    List<Seat> findAllByHall_UuidIn(List<UUID> uuids);

}
