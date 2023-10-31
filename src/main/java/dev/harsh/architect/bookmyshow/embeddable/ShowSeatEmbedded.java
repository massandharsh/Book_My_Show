package dev.harsh.architect.bookmyshow.embeddable;

import dev.harsh.architect.bookmyshow.models.Seat;
import dev.harsh.architect.bookmyshow.models.Show;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
public class ShowSeatEmbedded implements Serializable
{
     @ManyToOne
     private Show show;
     @ManyToOne
     private Seat seat;
}
