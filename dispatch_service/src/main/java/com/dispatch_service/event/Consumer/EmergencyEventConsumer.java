package com.dispatch_service.event.Consumer;

public class EmergencyEventConsumer {
    private final DispatchService dispatchService;

    public EmergencyEventConsumer(DispatchService dispatchService) {
        this.dispatchService = dispatchService;
    }

    public void handleEmergency(Object event) {
        dispatchService.dispatchEmergency(event);
    }

    public static class DispatchService {
        public void dispatchEmergency(Object event) {
            // no-op
        }
    }
}
