package dev.harsh.architect.bookmyshow.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class User extends BaseModel{
    @Column(unique = true)
    private String username;
    private String password;
}
