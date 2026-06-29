package com.emergency_service.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="emergencyImages")
public class EmergencyImage {
     

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emergency_id", nullable = false)
    private EmergencyRequest emergencyRequest;
    @Column(nullable=false)
    private String imageUrl;
    @Column(nullable=false)
    private LocalDateTime uploadedAt;

    public EmergencyImage(){

    }
    public EmergencyImage(UUID id,String imageUrl,LocalDateTime uploadedAt,EmergencyRequest emergencyRequest){
        this.id=id;
        this.imageUrl=imageUrl;
        this.uploadedAt=uploadedAt;
        this.emergencyRequest=emergencyRequest;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }
    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
    public EmergencyRequest getEmergencyRequest() {
        return emergencyRequest;
    }
    public void setEmergencyRequest(EmergencyRequest emergencyRequest) {
        this.emergencyRequest = emergencyRequest;
    }
    

}
