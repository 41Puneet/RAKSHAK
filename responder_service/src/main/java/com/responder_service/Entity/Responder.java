package com.responder_service.Entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import com.responder_service.Enums.ResponderType;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;


import com.responder_service.Enums.DutyStatus;
import com.responder_service.Enums.AvailabilityStatus;


@Entity
@Table(name="responder")
public class Responder {
    
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    @Column(nullable=false)
    private UUID userId;
    @Column(nullable=false,unique=true)
    private String badgeNumber;
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private ResponderType type;
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private AvailabilityStatus status;
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private DutyStatus dutyStatus ;
    @Column(nullable=false)
    private Double latitude;
    @Column(nullable=false)
    private Double longitude;
    @Column(nullable=false)
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy="responder",cascade = CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval = true)
    private ResponderVehicle responderVehicle;

   @OneToMany(
    mappedBy = "responder",
    cascade = CascadeType.ALL,
    orphanRemoval = true,
    fetch = FetchType.LAZY
)
private List<ResponderAssignment> assignments;
@OneToMany(
    mappedBy = "responder",
    cascade = CascadeType.ALL,
    orphanRemoval = true,
    fetch = FetchType.LAZY
)
    private List<ResponderLocationHistory>location;

    @OneToMany(
    mappedBy = "responder",
    cascade = CascadeType.ALL,
    orphanRemoval = true,
    fetch = FetchType.LAZY
)
    private List<ResponderAvailabilityHistory>history;
    
    public Responder(){

    }
    public Responder(UUID id,UUID userId,String badgeNumber,ResponderType type,AvailabilityStatus status,DutyStatus dutyStatus,Double latitude,Double longitude,boolean active,LocalDateTime createdAt,LocalDateTime updatedAt,List<ResponderLocationHistory>location,List<ResponderAvailabilityHistory>history,List<ResponderAssignment>assignments,ResponderVehicle responderVehicle){
        this.responderVehicle=responderVehicle;
        this.id=id;
        this.userId=userId;
        this.type=type;
        this.badgeNumber=badgeNumber;
        this.status=status;
        this.dutyStatus=dutyStatus;
        this.latitude=latitude;
        this.longitude=longitude;
        this.active=active;
        this.createdAt=createdAt;
        this.updatedAt=updatedAt;
        this.location=location;
        this.history=history;
        this.assignments=assignments;
    }
    public ResponderVehicle getResponderVehicle() {
        return responderVehicle;
    }
    public void setResponderVehicle(ResponderVehicle responderVehicle) {
        this.responderVehicle = responderVehicle;
    }
    public List<ResponderLocationHistory> getLocation() {
        return location;
    }
    public void setLocation(List<ResponderLocationHistory> location) {
        this.location = location;
    }
    public List<ResponderAvailabilityHistory> getHistory() {
        return history;
    }
    public void setHistory(List<ResponderAvailabilityHistory> history) {
        this.history = history;
    }
    public List<ResponderAssignment> getAssignments() {
        return assignments;
    }
    public void setAssignments(List<ResponderAssignment> assignments) {
        this.assignments = assignments;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getUserId() {
        return userId;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    public String getBadgeNumber() {
        return badgeNumber;
    }
    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }
    public ResponderType getType() {
        return type;
    }
    public void setType(ResponderType type) {
        this.type = type;
    }
    public AvailabilityStatus getStatus() {
        return status;
    }
    public void setStatus(AvailabilityStatus status) {
        this.status = status;
    }
    public DutyStatus getDutyStatus() {
        return dutyStatus;
    }
    public void setDutyStatus(DutyStatus dutyStatus) {
        this.dutyStatus = dutyStatus;
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
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
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
    @PrePersist
public void prePersist() {
    createdAt = LocalDateTime.now();
    updatedAt = LocalDateTime.now();
}

@PreUpdate
public void preUpdate() {
    updatedAt = LocalDateTime.now();
}
}
