package com.responder_service.DTO.request;

import java.time.LocalDateTime;
import java.util.UUID;
import com.responder_service.Enums.Assignment_Status;
import jakarta.validation.constraints.NotNull;

public class AssignResponderRequest {
    

    @NotNull
    private UUID id;
    @NotNull
    private Assignment_Status status;
    @NotNull
    private LocalDateTime assignedAt;
    
    

    public AssignResponderRequest(){

    }

    public AssignResponderRequest(UUID id,Assignment_Status status,LocalDateTime assignedAt){
     
        this.id=id;
        this.status=status;
        this.assignedAt=assignedAt;
    }
}

