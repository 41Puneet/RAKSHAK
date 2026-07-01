package com.dispatch_service.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dispatch_service.Entity.DispatchAssignment;
import com.dispatch_service.event.model.EmergencyCreatedEvent;
import com.dispatch_service.event.model.ResponderAssignedEvent;

@Mapper(componentModel = "spring")
public interface DispatchMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "responderId", ignore = true)
    @Mapping(target = "distanceKm", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "assignedAt", ignore = true)
    DispatchAssignment toDispatchAssignment(EmergencyCreatedEvent event);

    ResponderAssignedEvent toResponderAssignedEvent(DispatchAssignment assignment);

}