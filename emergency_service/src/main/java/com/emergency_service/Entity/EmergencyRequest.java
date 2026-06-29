package com.emergency_service.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.emergency_service.Enums.EmergencyType;
import com.emergency_service.Enums.Priority;
import com.emergency_service.Enums.Status;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "emergency_requests",
    indexes = {

        @Index(name = "idx_status", columnList = "status"),

        @Index(name = "idx_user", columnList = "userId"),

        @Index(name = "idx_created", columnList = "createdAt")

    }
)
public class EmergencyRequest {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID emergencyId;
    @Column(nullable=false)
    private UUID userId;
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private EmergencyType emergencyType;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable=false)
    private Double latitude;
    @Column(nullable=false)
    private Double longitude;
    private String address;
    @Column(nullable=false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UUID responderId;
    private UUID hospitalId;
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Priority priority;
    @Column(nullable=false)
    private boolean isActive;


    public EmergencyRequest(){

    }
    public EmergencyRequest(UUID emergencyId,UUID userId,EmergencyType emergencyType,String description,Status status,Double latitude,Double longitude,String address,LocalDateTime createdAt,LocalDateTime updatedAt,UUID responderId,UUID hospitalId,Priority priority,boolean isActive){
        this.emergencyId=emergencyId;
        this.userId=userId;
        this.emergencyType=emergencyType;
        this.description=description;
        this.status=status;
        this.latitude=latitude;
        this.hospitalId=hospitalId;
        this.longitude=longitude;
        this.address=address;
        this.createdAt=createdAt;
        this.updatedAt=updatedAt;
        this.responderId=responderId;
        this.priority=priority;
        this.isActive=isActive;
    }
    public UUID getEmergencyId() {
        return emergencyId;
    }
    public void setEmergencyId(UUID emergencyId) {
        this.emergencyId = emergencyId;
    }
    public UUID getUserId() {
        return userId;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    public EmergencyType getEmergencyType() {
        return emergencyType;
    }
    public void setEmergencyType(EmergencyType emergencyType) {
        this.emergencyType = emergencyType;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public UUID getResponderId() {
        return responderId;
    }
    public void setResponderId(UUID responderId) {
        this.responderId = responderId;
    }
    public UUID getHospitalId() {
        return hospitalId;
    }
    public void setHospitalId(UUID hospitalId) {
        this.hospitalId = hospitalId;
    }
    public Priority getPriority() {
        return priority;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
 

    public List<EmergencyImage> getImages() {
        return images;
    }
    public void setImages(List<EmergencyImage> images) {
        this.images = images;
    }
    public List<ResponderAssignment> getAssignments() {
        return assignments;
    }
    public void setAssignments(List<ResponderAssignment> assignments) {
        this.assignments = assignments;
    }
    public List<EmergencyLocationHistory> getLocationHistory() {
        return locationHistory;
    }
    public void setLocationHistory(List<EmergencyLocationHistory> locationHistory) {
        this.locationHistory = locationHistory;
    }


    @OneToMany(mappedBy="emergencyRequest",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
private List<EmergencyImage> images=new ArrayList<>();


@OneToMany(
    mappedBy = "emergencyRequest",
    cascade = CascadeType.ALL,
    orphanRemoval = true,
    fetch = FetchType.LAZY
)
private List<ResponderAssignment> assignments = new ArrayList<>();

@OneToMany(
    mappedBy = "emergencyRequest",
    cascade = CascadeType.ALL,
    orphanRemoval = true,
    fetch = FetchType.LAZY
)

private List<EmergencyLocationHistory> locationHistory = new ArrayList<>();
}
