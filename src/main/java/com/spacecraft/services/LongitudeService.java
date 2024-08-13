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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@Getter
public class LongitudeService {

    public List<LongitudeDTO> longitudes;

    @PostConstruct
    public void loadData() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get("src", "main", "resources", "persistence", "longitudes.json");

        longitudes = objectMapper.readValue(
                Files.readAllBytes(path), new TypeReference<List<LongitudeDTO>>() {}
        );
        for (LongitudeDTO longitudeDTO: longitudes){
            System.out.println(longitudeDTO);
        }
    }
}
