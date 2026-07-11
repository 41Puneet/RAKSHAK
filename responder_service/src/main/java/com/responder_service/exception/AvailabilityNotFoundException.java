package com.responder_service.exception;

public class AvailabilityNotFoundException extends RuntimeException {

    public AvailabilityNotFoundException() {
    }

    public AvailabilityNotFoundException(String message) {
        super(message);
    }
}
