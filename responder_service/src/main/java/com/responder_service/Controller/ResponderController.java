package com.responder_service.Controller;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import com.responder_service.DTO.request.CompleteAssignmentRequest;
import com.responder_service.DTO.request.CreateResponderRequest;
import com.responder_service.DTO.request.RegisterVehicleRequest;
import com.responder_service.DTO.request.UpdateAvailabilityRequest;
import com.responder_service.DTO.request.UpdateResponder;
import com.responder_service.DTO.request.UpdateVehicleRequest;
import com.responder_service.DTO.response.AssignmentResponse;
import com.responder_service.DTO.response.AvailabilityHistoryResponse;
import com.responder_service.DTO.response.LocationHistoryResponse;
import com.responder_service.DTO.response.ResponderResponse;
import com.responder_service.DTO.response.VehicleResponse;
import com.responder_service.Enums.Assignment_Status;
import com.responder_service.service.ResponderService;

@RestController
@RequestMapping("/api/responder")
@Validated
public class ResponderController {
    

    private final ResponderService service;
    public ResponderController(ResponderService service){
        this.service=service;

    }

    @PostMapping("/responders")
    public ResponseEntity<ResponderResponse> createResponder(
            @Valid @RequestBody CreateResponderRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createResponder(request));
    }

    @GetMapping("/responders/{responderId}")
    public ResponseEntity<ResponderResponse> getResponderById(@PathVariable UUID responderId) {
        return ResponseEntity.ok(service.getResponderByID(responderId));
    }

    @PutMapping("/responders/{responderId}")
    public ResponseEntity<ResponderResponse> updateResponder(
            @PathVariable UUID responderId,
            @Valid @RequestBody UpdateResponder request) {
        return ResponseEntity.ok(service.updateResponder(responderId, request));
    }

    @PostMapping("/assignments/complete")
    public ResponseEntity<AssignmentResponse> completeAssignment(
            @Valid @RequestBody CompleteAssignmentRequest request) {
        return ResponseEntity.ok(service.completeAssignment(request));
    }

    @GetMapping("/assignments/{assignmentId}")
    public ResponseEntity<AssignmentResponse> getAssignmentById(@PathVariable UUID assignmentId) {
        return ResponseEntity.ok(service.getAssignmentById(assignmentId));
    }

    @GetMapping("/responders/{responderId}/assignments")
    public ResponseEntity<Page<AssignmentResponse>> getAssignmentsByResponder(
            @PathVariable UUID responderId,
            Pageable pageable) {
        return ResponseEntity.ok(service.getAssignmentResponseByResponderId(responderId, pageable));
    }

    @GetMapping("/responders/{responderId}/assignments/status/{status}")
    public ResponseEntity<Page<AssignmentResponse>> getAssignmentsByStatus(
            @PathVariable UUID responderId,
            @PathVariable Assignment_Status status,
            Pageable pageable) {
        return ResponseEntity.ok(service.getByAssignmentStatus(responderId, status, pageable));
    }

    @PostMapping("/vehicles")
    public ResponseEntity<VehicleResponse> registerVehicle(
            @Valid @RequestBody RegisterVehicleRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registerVehicle(request));
    }

    @GetMapping("/vehicles/{vehicleId}")
    public ResponseEntity<VehicleResponse> getVehicleById(@PathVariable UUID vehicleId) {
        return ResponseEntity.ok(service.getVehicleByID(vehicleId));
    }

    @GetMapping("/responders/{responderId}/vehicle")
    public ResponseEntity<VehicleResponse> getVehicleByResponder(@PathVariable UUID responderId) {
        return ResponseEntity.ok(service.getVehicleByResponder(responderId));
    }

    @PutMapping("/vehicles/{vehicleId}")
    public ResponseEntity<VehicleResponse> updateVehicle(
            @PathVariable UUID vehicleId,
            @Valid @RequestBody UpdateVehicleRequest request) {
        return ResponseEntity.ok(service.updateVehicle(vehicleId, request));
    }

    @DeleteMapping("/vehicles/{vehicleId}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable UUID vehicleId) {
        service.deleteVehicle(vehicleId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/vehicles")
    public ResponseEntity<Page<VehicleResponse>> getVehiclesByActive(
            @RequestParam(defaultValue = "true") boolean active,
            Pageable pageable) {
        return ResponseEntity.ok(service.getByActiveVehicle(active, pageable));
    }

    @PatchMapping("/responders/{responderId}/availability")
    public ResponseEntity<AvailabilityHistoryResponse> updateAvailability(
            @PathVariable UUID responderId,
            @Valid @RequestBody UpdateAvailabilityRequest request) {
        return ResponseEntity.ok(service.updateAvailability(request, responderId));
    }

    @GetMapping("/responders/{responderId}/availability")
    public ResponseEntity<Page<AvailabilityHistoryResponse>> getAvailabilityHistory(
            @PathVariable UUID responderId,
            Pageable pageable) {
        return ResponseEntity.ok(service.getAvailabilityByResponderId(responderId, pageable));
    }

    @GetMapping("/responders/{responderId}/locations")
    public ResponseEntity<Page<LocationHistoryResponse>> getLocationHistory(
            @PathVariable UUID responderId,
            Pageable pageable) {
        return ResponseEntity.ok(service.getLocationByResponderId(responderId, pageable));
    }

    @GetMapping("/responders/{responderId}/locations/latest")
    public ResponseEntity<LocationHistoryResponse> getLatestLocation(
            @PathVariable UUID responderId) {
        return ResponseEntity.ok(service.getByResponderIdAndTime(responderId));
    }

    @GetMapping("/locations")
    public ResponseEntity<Page<LocationHistoryResponse>> getLocationsBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
            Pageable pageable) {
        return ResponseEntity.ok(service.getByTimeBetween(start, end, pageable));
    }
} 
