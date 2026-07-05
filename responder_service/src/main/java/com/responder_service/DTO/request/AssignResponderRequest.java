package com.responder_service.DTO.request;

import java.time.LocalDateTime;

import com.responder_service.Enums.Assignment_Status;

public class AssignResponderRequest {
    

@NotNull
    private UUID id;
    @NotNull
    private Assignment_Status status;
    @NotNull
    private LocalDateTime assignedAt;
    @NotNull
    private LocalDateTime acceptedAt;
}
