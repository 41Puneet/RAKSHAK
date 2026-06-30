package com.dispatch_service.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;



@Entity
@Table(
    name = "responder_location",
    indexes = {
        @Index(name = "idx_responder_available", columnList = "responderId, isAvailable"),
        @Index(name = "idx_location", columnList = "latitude, longitude")
    }
)
public class ResponderLocation {
    

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    @Column(nullable=false,unique=true)
    private UUID responderId;
    @Column(nullable=false)
    private Double latitude;
    @Column(nullable=false)
    private Double longitude;
    private boolean isAvailable;
    private LocalDateTime lastUpdated;

 public ResponderLocation(){

 }
 public ResponderLocation(UUID id,UUID responderId,Double latitude,Double longitude,boolean isAvailable,LocalDateTime lastUpdated){
    this.id=id;
    this.responderId=responderId;
    this.latitude=latitude;
    this.longitude=longitude;
    this.isAvailable=isAvailable;
    this.lastUpdated=lastUpdated;
 }
 public UUID getId() {
    return id;
 }
 public void setId(UUID id) {
    this.id = id;
 }
 public UUID getResponderId() {
    return responderId;
 }
 public void setResponderId(UUID responderId) {
    this.responderId = responderId;
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
 public boolean isAvailable() {
    return isAvailable;
 }
 public void setAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
 }
 public LocalDateTime getLastUpdated() {
    return lastUpdated;
 }
 public void setLastUpdated(LocalDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
 }
 
}
