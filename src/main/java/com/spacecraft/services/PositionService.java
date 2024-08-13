package com.spacecraft.services;

import com.spacecraft.dtos.LatitudeDTO;
import com.spacecraft.dtos.LongitudeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

@Service
public class PositionService {
    private DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
    private final LatitudeService latitudeService;
    private final LongitudeService longitudeService;

    @Autowired
    public PositionService(LatitudeService latitudeService,
                           LongitudeService longitudeService){
        this.latitudeService = latitudeService;
        this.longitudeService = longitudeService;
    }

    public LatitudeDTO getClosestEventLatitude(String eventTime) {
        LocalDateTime eventDateTime = LocalDateTime.parse(eventTime, formatter);

        return latitudeService.getLatitudes().stream()
                .min(Comparator.comparing(lat -> Math.abs(ChronoUnit.SECONDS.between(
                        LocalDateTime.parse(lat.getTimestamp(), formatter),
                        eventDateTime))))
                .orElse(null);
    }

    public LongitudeDTO getClosestEventLongitude(String eventTime){
        LocalDateTime eventDateTime = LocalDateTime.parse(eventTime, formatter);

        return longitudeService.getLongitudes().stream()
                .min(Comparator.comparing(lon -> Math.abs(ChronoUnit.SECONDS.between(
                        LocalDateTime.parse(lon.getTimestamp(), formatter),
                        eventDateTime))))
                .orElse(null);
    }
}
