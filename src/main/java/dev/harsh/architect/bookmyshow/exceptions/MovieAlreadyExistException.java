package dev.harsh.architect.bookmyshow.exceptions;

public class MovieAlreadyExistException extends RuntimeException {
    public MovieAlreadyExistException(String name) {
        super("Movie with the given name: " + name + " already exists");
    }
}
