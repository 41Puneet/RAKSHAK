package com.notification_service.Controller;

import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.notification_service.DTO.Request.MarkNotificationAsReadRequestDTO;
import com.notification_service.DTO.Request.SendNotificationRequestDTO;
import com.notification_service.DTO.Response.NotificationResponseDTO;
import com.notification_service.Service.NotificationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController @Validated @RequestMapping("/api/notifications") @Tag(name="Notifications") @SecurityRequirement(name="bearerAuth")
public class NotificationController {
    private final NotificationService service;
    public NotificationController(NotificationService service){this.service=service;}
    @PostMapping @Operation(summary="Create a notification") public ResponseEntity<NotificationResponseDTO> create(@Valid @RequestBody SendNotificationRequestDTO request){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));}
    @GetMapping @Operation(summary="List notifications for the authenticated user") public Page<NotificationResponseDTO> list(@AuthenticationPrincipal Jwt jwt,@PageableDefault(size=25) Pageable pageable){return service.list(userId(jwt),pageable);}
    @PatchMapping("/{id}/read") @Operation(summary="Mark a notification as read") public NotificationResponseDTO read(@PathVariable UUID id,@AuthenticationPrincipal Jwt jwt){return service.markRead(userId(jwt),id);}
    private UUID userId(Jwt jwt){return UUID.fromString(jwt.getClaimAsString("userId"));}
}
