package dev.harsh.architect.bookmyshow.models;

import dev.harsh.architect.bookmyshow.enums.Feature;
import dev.harsh.architect.bookmyshow.enums.Language;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movie_show")
@Builder(toBuilder = true)
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;

    private Date startTime;
    private Integer duration;

    @ManyToOne
    private Hall hall;

    @OneToMany(mappedBy = "show")
    private List<ShowSeat> seats;

    @Enumerated
    private Feature feature;

    @Enumerated
    private Language language;

}
