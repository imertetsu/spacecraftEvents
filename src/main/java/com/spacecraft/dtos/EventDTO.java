package com.spacecraft.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EventDTO {
    @JsonProperty("occurrence_time")
    private String occurrenceTime;
    @JsonProperty("event_name")
    private String eventName;
    private String id;
    private String severity;
    private double longitude;
    private double latitude;
}
