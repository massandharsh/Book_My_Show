package dev.harsh.architect.bookmyshow.repositories;

import dev.harsh.architect.bookmyshow.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, UUID> {
    List<ShowSeat> findAllByShow_Uuid(UUID showId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<ShowSeat> findAllByUuidIn(Collection <UUID> uuids);
}
