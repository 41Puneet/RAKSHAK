package com.emergency_service.Controller;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.emergency_service.DTO.Request.EmergencyImageRequestDTO;
import com.emergency_service.DTO.Request.EmergencyRequestDTO;
import com.emergency_service.DTO.Response.EmergencyResponseDTO;
import com.emergency_service.Service.ControlRoomService;
import com.emergency_service.Service.EmergencyService;
import com.emergency_service.Enums.EmergencyType;
import com.emergency_service.Enums.Priority;
import com.emergency_service.Enums.Status;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/emergencies")
public class EmergencyServiceController {

    private final EmergencyService emergencyService;
    private final ControlRoomService controlRoomService;

    public EmergencyServiceController(EmergencyService emergencyService,
                               ControlRoomService controlRoomService) {
        this.emergencyService = emergencyService;
        this.controlRoomService = controlRoomService;
    }

    // Create Emergency
    @PostMapping
    public ResponseEntity<EmergencyResponseDTO> createEmergency(
            @Valid @RequestBody EmergencyRequestDTO dto,
            @RequestHeader("X-User-Id") UUID userId) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(emergencyService.createEmergency(dto, userId));
    }

    // Cancel Emergency
    @PutMapping("/{emergencyId}/cancel")
    public ResponseEntity<EmergencyResponseDTO> cancelEmergency(
            @PathVariable UUID emergencyId) {

        return ResponseEntity.ok(
                emergencyService.cancelEmergency(emergencyId));
    }

    // Upload Images
    @PostMapping("/{emergencyId}/images")
    public ResponseEntity<EmergencyResponseDTO> uploadImages(
            @PathVariable UUID emergencyId,
            @RequestBody EmergencyImageRequestDTO dto) {

        return ResponseEntity.ok(
                emergencyService.uploadImages(emergencyId, dto));
    }

    // Get Emergency By Id
    @GetMapping("/{emergencyId}")
    public ResponseEntity<EmergencyResponseDTO> getEmergencyById(
            @PathVariable UUID emergencyId) {

        return ResponseEntity.ok(
                emergencyService.getEmergencyById(emergencyId));
    }

    // Get Active Emergency Of User
    @GetMapping("/active")
    public ResponseEntity<EmergencyResponseDTO> getActiveEmergency(
            @RequestHeader("X-User-Id") UUID userId) {

        return ResponseEntity.ok(
                emergencyService.getActiveEmergencyByUserId(userId));
    }

    // ---------------- CONTROL ROOM APIs ----------------

   

    @GetMapping("/status/{status}")
    public ResponseEntity<Page<EmergencyResponseDTO>> getByStatus(
            @PathVariable Status status,
            Pageable pageable) {

        return ResponseEntity.ok(
                controlRoomService.getEmergencyByStatus(status, pageable));
    }

    @GetMapping("/priority/{priority}")
    public ResponseEntity<Page<EmergencyResponseDTO>> getByPriority(
            @PathVariable Priority priority,
            Pageable pageable) {

        return ResponseEntity.ok(
                controlRoomService.getEmergencyByPriority(priority, pageable));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<Page<EmergencyResponseDTO>> getByType(
            @PathVariable EmergencyType type,
            Pageable pageable) {

        return ResponseEntity.ok(
                controlRoomService.getEmergencyByType(type, pageable));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Page<EmergencyResponseDTO>> getByUser(
            @PathVariable UUID userId,
            Pageable pageable) {

        return ResponseEntity.ok(
                controlRoomService.getEmergencyByUserId(userId, pageable));
    }

    @GetMapping("/responder/{responderId}")
    public ResponseEntity<Page<EmergencyResponseDTO>> getByResponder(
            @PathVariable UUID responderId,
            Pageable pageable) {

        return ResponseEntity.ok(
                controlRoomService.getEmergencyByResponderId(responderId, pageable));
    }

    @GetMapping("/active/{active}")
    public ResponseEntity<Page<EmergencyResponseDTO>> getByActive(
            @PathVariable boolean active,
            Pageable pageable) {

        return ResponseEntity.ok(
                controlRoomService.getEmergencyByActiveTrue(active, pageable));
    }

    @GetMapping("/created-between")
    public ResponseEntity<Page<EmergencyResponseDTO>> getByCreatedBetween(
            @RequestParam String start,
            @RequestParam String end,
            Pageable pageable) {

        return ResponseEntity.ok(
                controlRoomService.getEmergencyByCreatedAtBetween(
                        java.time.LocalDateTime.parse(start),
                        java.time.LocalDateTime.parse(end),
                        pageable));
    }
}