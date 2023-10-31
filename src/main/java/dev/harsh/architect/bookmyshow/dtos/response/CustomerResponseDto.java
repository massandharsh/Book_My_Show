package dev.harsh.architect.bookmyshow.dtos.response;

import dev.harsh.architect.bookmyshow.models.Customer;
import dev.harsh.architect.bookmyshow.models.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponseDto {
    private String id;
    private String username;
    private String fullName;
    private String city;
    private String phoneNumber;
    private String email;

}
