package com.spacecraft.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spacecraft.dtos.EventDTO;
import com.spacecraft.dtos.LongitudeDTO;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
@Getter
public class EventService {

    private List<EventDTO> events;

    @PostConstruct
    public void loadData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        events = objectMapper.readValue(
                Files.readAllBytes(Paths.get("src/main/java/com/spacecraft/persistence/events.json")),
                new TypeReference<List<EventDTO>>() {}
        );
        for (EventDTO event : events) {
            System.out.println(event);
        }
    }

}