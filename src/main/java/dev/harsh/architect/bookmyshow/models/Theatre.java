package dev.harsh.architect.bookmyshow.models;

import jakarta.persistence.*;
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
@Entity
public class Theatre extends BaseModel{
    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;
    private String address;
    private String pinCode;
    @OneToMany
    private List<Hall> halls = new ArrayList<>();

}
