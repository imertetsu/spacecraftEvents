package com.spacecraft.controllers;

import com.spacecraft.dtos.EventDTO;
import com.spacecraft.services.EventService;
import com.spacecraft.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController()
public class EventController {
    private final EventService eventService;
    private final PositionService positionService;

    @Autowired
    public EventController(EventService eventService,
                           PositionService positionService){
        this.eventService = eventService;
        this.positionService = positionService;
    }

    @GetMapping("/events")
    public ResponseEntity<List<EventDTO>> getAllEvents(){
        List<EventDTO> events = eventService.getEvents();
        events.forEach(event -> {
            event.setLatitude(positionService.getClosestEventLatitude(event.getOccurrenceTime()).getPosition());
            event.setLongitude(positionService.getClosestEventLongitude(event.getOccurrenceTime()).getPosition());
        });

        return ResponseEntity.ok(this.eventService.getEvents());
    }
    @GetMapping("/position/{id}")
    public ResponseEntity<EventDTO> getEventPositionById(@PathVariable String id){
        Optional<EventDTO> eventOpt = eventService.getEvents().stream()
                .filter(event -> event.getId().equals(id))
                .findFirst();

        if(eventOpt.isPresent()){
            EventDTO eventDTO = eventOpt.get();
            eventDTO.setLatitude(positionService.getClosestEventLatitude(eventDTO.getOccurrenceTime()).getPosition());
            eventDTO.setLongitude(positionService.getClosestEventLongitude(eventDTO.getOccurrenceTime()).getPosition());
            return ResponseEntity.ok(eventDTO);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
}
