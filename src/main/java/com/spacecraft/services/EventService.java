package com.spacecraft.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spacecraft.dtos.EventDTO;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Getter
public class EventService {

    private List<EventDTO> events;

    @PostConstruct
    public void loadData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("persistence/events.json");
        events = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<EventDTO>>() {});
    }

}
