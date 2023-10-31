package dev.harsh.architect.bookmyshow.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.harsh.architect.bookmyshow.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Show show;
    @ManyToMany
    @JsonIgnore
    private List<ShowSeat> showSeats;

    private Double amount;

    @OneToMany
    private List<Payment> payments;

    @Enumerated
    @Builder.Default
    private BookingStatus status = BookingStatus.PENDING;
}
