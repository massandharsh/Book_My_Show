package dev.harsh.architect.bookmyshow.exceptions;

public class CustomerWithEmailAlreadyExistException extends RuntimeException {
    public CustomerWithEmailAlreadyExistException(String email){
        super("Customer with email already exists : " + email);
    }
}
