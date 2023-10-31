package dev.harsh.architect.bookmyshow.repositories;


import dev.harsh.architect.bookmyshow.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Optional<Customer> findCustomerByEmail(String email);
}
