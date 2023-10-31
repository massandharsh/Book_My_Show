package dev.harsh.architect.bookmyshow.models;


import dev.harsh.architect.bookmyshow.embeddable.ShowSeatEmbedded;
import dev.harsh.architect.bookmyshow.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private SeatStatus seatStatus = SeatStatus.AVAILABLE;
}
