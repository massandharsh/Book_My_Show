package dev.harsh.architect.bookmyshow.models;

import dev.harsh.architect.bookmyshow.enums.Category;
import dev.harsh.architect.bookmyshow.enums.Feature;
import dev.harsh.architect.bookmyshow.enums.Language;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Movie extends BaseModel{
    private String name;
    @ElementCollection
    @Enumerated
    private List<Language> languages;

    private double rating;

    @Enumerated
    private Category category;

    @ElementCollection
    @Enumerated
    private List<Feature> features;


}
