package com.spacecraft.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spacecraft.dtos.LatitudeDTO;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
@Getter
public class LatitudeService {

    private List<LatitudeDTO> latitudes;

    @PostConstruct
    public void loadData() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        latitudes = objectMapper.readValue(
                Files.readAllBytes(Paths.get("src/main/java/com/spacecraft/persistence/latitudes.json")),
                new TypeReference<List<LatitudeDTO>>() {}
        );
    }
}
