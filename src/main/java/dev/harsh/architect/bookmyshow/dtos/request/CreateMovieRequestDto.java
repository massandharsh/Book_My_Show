package dev.harsh.architect.bookmyshow.dtos.request;

import dev.harsh.architect.bookmyshow.enums.Category;
import dev.harsh.architect.bookmyshow.enums.Feature;
import dev.harsh.architect.bookmyshow.enums.Language;
import dev.harsh.architect.bookmyshow.models.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMovieRequestDto {
    private String name;
    private Double rating;
    private List<Language> languages = new ArrayList<>();
    private List<Feature> features = new ArrayList<>();
    private Category category;

    public Movie toMovie(){
        return Movie.builder()
                .category(category)
                .features(features)
                .languages(languages)
                .rating(rating)
                .name(name)
                .build();
    }

}
