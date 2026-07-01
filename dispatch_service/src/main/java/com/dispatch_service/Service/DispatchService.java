package com.dispatch_service.Service;

import com.dispatch_service.event.model.EmergencyCreatedEvent;

public interface DispatchService {
    void dispatchEmergency(EmergencyCreatedEvent event);
}
