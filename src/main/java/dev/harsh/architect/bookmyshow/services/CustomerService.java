package dev.harsh.architect.bookmyshow.services;


import dev.harsh.architect.bookmyshow.dtos.response.CustomerResponseDto;
import dev.harsh.architect.bookmyshow.models.Customer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public interface CustomerService {
    CustomerResponseDto getCustomer(UUID uuid);
    CustomerResponseDto createCustomer(Customer customer);

        static CustomerResponseDto toCustomerResponseDto(Customer customer){
        return CustomerResponseDto.builder()
                .email(customer.getEmail())
                .city(customer.getCity())
                .phoneNumber(customer.getPhoneNumber())
                .fullName(customer.getFullName())
                .username(customer.getUser().getUsername())
                .id(String.valueOf(customer.getUuid()))
                .build();
    }

    Customer getCustomerInternal(UUID id);
}
