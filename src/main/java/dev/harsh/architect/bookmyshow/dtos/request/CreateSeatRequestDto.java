package dev.harsh.architect.bookmyshow.dtos.request;

import dev.harsh.architect.bookmyshow.enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateSeatRequestDto {
    private SeatType seatType;
    private int row;
    private int col;
}
