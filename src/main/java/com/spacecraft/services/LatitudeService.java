package com.spacecraft.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spacecraft.dtos.LatitudeDTO;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Getter
public class LatitudeService {

    private List<LatitudeDTO> latitudes;

    @PostConstruct
    public void loadData() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("persistence/latitudes.json");

        latitudes = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<LatitudeDTO>>() {});
    }
}
