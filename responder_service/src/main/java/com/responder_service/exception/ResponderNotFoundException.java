package com.responder_service.exception;

public class ResponderNotFoundException extends RuntimeException {

    public ResponderNotFoundException() {
    }

    public ResponderNotFoundException(String message) {
        super(message);
    }
}
