package com.dispatch_service.Service;

import com.dispatch_service.Entity.ResponderLocation;

public interface ResponderSelectionService{
    ResponderLocation findNearestAvailableResponder(
            Double latitude,
            Double longitude
    );
}