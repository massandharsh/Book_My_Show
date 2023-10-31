package dev.harsh.architect.bookmyshow.dtos.request;

import dev.harsh.architect.bookmyshow.enums.Feature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CreateHallRequestDto {
    private String name;
    private int hallNumber;
    private List<Feature> features;

    private List<CreateSeatRequestDto> seatRequest;
}
