package com.spacecraft.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class SwaggerConfig {
    @Value("${swagger.server.url}")
    private String swaggerServerUrl;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()

                .info(new Info()
                        .title("API Documentation")
                        .version("1.0")
                        .description("""
                                API designed to integrate spacecraft onboard event data with geographic position data (latitude and longitude). This application provides a REST API that allows users to retrieve the exact or closest geographic positions of the spacecraft at the time of various onboard events, ensuring accurate tracking and monitoring of the spacecraft's operational status.
                                \n Retrieve Event Position by ID: Users can request the precise geographic position (latitude and longitude) of the spacecraft at the time of a specific event by providing the event's unique ID.
                                \n List All Events with Positions: The application offers an endpoint to retrieve a comprehensive list of all onboard events, each accompanied by the corresponding latitude and longitude at the time of the event.""")
                        .contact(new Contact().name("Imer Coaguila").url("https://portafoliotetsu.web.app").email("imertetsu@gmail.com")))
                .servers(Collections.singletonList(new Server().url(swaggerServerUrl)));
    }
}
