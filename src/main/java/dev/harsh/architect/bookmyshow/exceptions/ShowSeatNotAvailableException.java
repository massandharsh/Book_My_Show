package dev.harsh.architect.bookmyshow.exceptions;

import dev.harsh.architect.bookmyshow.models.ShowSeat;

public class ShowSeatNotAvailableException extends RuntimeException {
    public ShowSeatNotAvailableException() {
        super("Some show seats are not available");
    }
}
