package dev.harsh.architect.bookmyshow.controllers;

import dev.harsh.architect.bookmyshow.dtos.request.CustomerRequestDto;
import dev.harsh.architect.bookmyshow.dtos.response.CustomerResponseDto;
import dev.harsh.architect.bookmyshow.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {
    //Get Customer
    // /customer/{id}
    private CustomerService customerService;
    @GetMapping("/{id}")
    public CustomerResponseDto getCustomer(@PathVariable("id") UUID id){
        return customerService.getCustomer(id);
    }

    @PostMapping
    public CustomerResponseDto createCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        return customerService.createCustomer(customerRequestDto.toCustomer());
    }
}
