package dev.harsh.architect.bookmyshow.dtos.request;

import dev.harsh.architect.bookmyshow.enums.Feature;
import dev.harsh.architect.bookmyshow.enums.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShowRequestDto{
    private UUID hallId;
    private UUID movieId;
    private Date startTime;
    private Integer duration;
    private Feature feature;
    private Language language;

}
