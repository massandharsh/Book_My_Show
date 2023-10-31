package dev.harsh.architect.bookmyshow.services;


import dev.harsh.architect.bookmyshow.dtos.response.CustomerResponseDto;
import dev.harsh.architect.bookmyshow.exceptions.CustomerNotFoundException;
import dev.harsh.architect.bookmyshow.exceptions.CustomerWithEmailAlreadyExistException;
import dev.harsh.architect.bookmyshow.models.Customer;
import dev.harsh.architect.bookmyshow.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service("selfCustomerService")
@Primary
@AllArgsConstructor
public class SelfCustomerService implements CustomerService{
    private final CustomerRepository customerRepository;
    @Override
    public CustomerResponseDto getCustomer(UUID id) {
         Customer customer = customerRepository.findById(id)
                 .orElseThrow(()-> new CustomerNotFoundException(id));
         return CustomerService.toCustomerResponseDto(customer);
    }

    @Override
    public CustomerResponseDto createCustomer(Customer customer) {
        //Check if email already exists else throw exception
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
        if(customerOptional.isPresent()){
            throw new CustomerWithEmailAlreadyExistException(customer.getEmail());
        }
        Customer persistedCustomer = customerRepository.save(customer);
        return CustomerService.toCustomerResponseDto(persistedCustomer);
    }

    @Override
    public Customer getCustomerInternal(UUID id) {
        return customerRepository.findById(id)
                .orElseThrow(null);
    }
}
