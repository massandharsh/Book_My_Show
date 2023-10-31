package dev.harsh.architect.bookmyshow.exceptions;

import java.util.UUID;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(UUID id) {
        super("Customer with id : " + id + " Not found");
    }
}
