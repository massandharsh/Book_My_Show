package dev.harsh.architect.bookmyshow.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookingRequestDto {
    private UUID customerId;
    private UUID showId;
    private List<UUID> showSeatsIds = new ArrayList<>();

}
