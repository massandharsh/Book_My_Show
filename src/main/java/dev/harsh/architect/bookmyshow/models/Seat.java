package dev.harsh.architect.bookmyshow.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.harsh.architect.bookmyshow.enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Seat extends BaseModel{
    private int rowNo;
    private int colNo;
    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn(name="hall_id")
    @JsonIgnore
    private Hall hall;
}
