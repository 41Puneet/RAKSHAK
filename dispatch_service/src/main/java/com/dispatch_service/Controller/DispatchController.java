package com.dispatch_service.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dispatch_service.Entity.DispatchAssignment;
import com.dispatch_service.Entity.DispatchLog;
import com.dispatch_service.Service.DispatchService;
import com.dispatch_service.event.model.EmergencyCreatedEvent;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("testing/dispatch")
public class DispatchController {
    

    private final DispatchService dispatchService;

    public DispatchController(DispatchService dispatchService){
        this.dispatchService=dispatchService;
    }
    @PostMapping("/trigger")
public ResponseEntity<String> triggerDispatch(
        @RequestBody EmergencyCreatedEvent event) {

    dispatchService.dispatchEmergency(event);

    return ResponseEntity.ok("Dispatch triggered successfully");
}
@GetMapping("/assignment/{emergencyId}")
public ResponseEntity<DispatchAssignment> getAssignment(@PathVariable UUID emergencyId) {
    return ResponseEntity.ok(
            dispatchService.getAssignmentByEmergencyId(emergencyId)
    );
}
@GetMapping("/logs/{emergencyId}")
public ResponseEntity<List<DispatchLog>> getLogs(@PathVariable UUID emergencyId) {
    return ResponseEntity.ok(
            dispatchService.getLogs(emergencyId)
    );
}
}
