package com.dispatch_service.ServiceImpl;

import org.springframework.stereotype.Service;

import com.dispatch_service.Repository.DispatchLogRepository;
import com.dispatch_service.Service.ResponderSelectionService;
import com.dispatch_service.Service.DispatchService;
import com.dispatch_service.event.model.EmergencyCreatedEvent;
import com.dispatch_service.Service.GeoService;
import com.dispatch_service.event.producer.DispatchEventProducer;
import com.dispatch_service.Repository.DispatchAssignmentRepository;
import com.dispatch_service.Repository.ResponderLocationRepository;
import com.dispatch_service.mapper.DispatchMapper;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class DispatchServiceImpl implements DispatchService{

    private final ResponderSelectionService responderSelectionService;
    private final DispatchService dispatchService;
    private final GeoService geoService;
    private final DispatchEventProducer dispatchEventProducer;
    private final DispatchAssignmentRepository dispatchAssignmentRepository;
    private final DispatchLogRepository DispatchLogRepository;
    private final ResponderLocationRepository responderLocationRepository;
    private final DispatchMapper dispatchMapper;
    

    public DispatchServiceImpl(ResponderSelectionService responderSelectionService,DispatchService dispatchService,GeoService geoService,DispatchEventProducer dispatchEventProducer,DispatchAssignmentRepository dispatchAssignmentRepository,ResponderLocationRepository responderLocationRepository,DispatchLogRepository DispatchLogRepository,DispatchMapper dispatchMapper) {
        this.responderSelectionService = responderSelectionService;
        this.dispatchService = dispatchService;
        this.geoService = geoService;
        this.dispatchEventProducer = dispatchEventProducer;
        this.dispatchAssignmentRepository = dispatchAssignmentRepository;
        this.responderLocationRepository = responderLocationRepository;
        this.DispatchLogRepository = DispatchLogRepository;
        this.dispatchMapper = dispatchMapper;
    }

    @Override
    public void dispatchEmergency(EmergencyCreatedEvent event) {
       
    }


}
