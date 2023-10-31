package dev.harsh.architect.bookmyshow.exceptions;

import java.util.UUID;

public class MovieDoesNotExistException extends RuntimeException{
    public MovieDoesNotExistException(UUID id) {
        super("Movie with the id : " + id + " does not exist");
    }
}
