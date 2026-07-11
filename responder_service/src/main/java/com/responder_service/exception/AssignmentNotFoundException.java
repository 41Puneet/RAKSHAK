package com.responder_service.exception;

public class AssignmentNotFoundException extends RuntimeException{
    public AssignmentNotFoundException(String message){
        super(message);
    }
}
