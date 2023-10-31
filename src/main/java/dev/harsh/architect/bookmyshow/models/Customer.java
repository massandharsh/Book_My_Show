package dev.harsh.architect.bookmyshow.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Builder
public class Customer extends BaseModel{
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    private User user;
    private String fullName;
    private String city;
    private String phoneNumber;
    @Column(unique = true)
    private String email;
}
