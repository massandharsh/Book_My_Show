package dev.harsh.architect.bookmyshow.exceptions;

import java.util.UUID;

public class ShowDoesNotExistException extends RuntimeException{
    public ShowDoesNotExistException(UUID id) {
        super("Show with id: " + id + " does not exist");
    }
}
