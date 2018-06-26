package com.globomatics.bike.exceptions;

public class BikeNotFoundException extends RuntimeException {

    public BikeNotFoundException(String message) {
        super(message);
    }

    public BikeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BikeNotFoundException(Throwable cause) {
        super(cause);
    }
}
