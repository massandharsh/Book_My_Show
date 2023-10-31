package dev.harsh.architect.bookmyshow.dtos.request;

import dev.harsh.architect.bookmyshow.models.Customer;
import dev.harsh.architect.bookmyshow.models.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CustomerRequestDto {
    private String username;
    private String fullName;
    private String city;
    private String phoneNumber;
    private String email;
    private String password;

    public Customer toCustomer(){
        return Customer.builder()
                .fullName(fullName)
                .city(city)
                .phoneNumber(phoneNumber)
                .email(email)
                .user(User.builder()
                        .password(password)
                        .username(username)
                        .build()
                ).build();
    }
}
