package dev.harsh.architect.bookmyshow.models;

import dev.harsh.architect.bookmyshow.enums.Feature;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Hall extends BaseModel{
    private int hallNumber;

    @OneToMany(mappedBy = "hall")
    private List<Seat> seats;

    @ElementCollection
    @Enumerated
    private List<Feature> features;
}
