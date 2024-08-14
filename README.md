# Spacecraft Events Application

This Spring Boot application combines spacecraft onboard events with geographic positions (latitude and longitude) and provides a REST interface to deliver accurate positions for the events.

## Prerequisites

- **Java 17**: Ensure you have Java 17 installed on your machine. You can verify this by running:

  ```bash
  java -version

## Building the Application
### Windows
Open a terminal or command prompt.
Navigate to the root directory of the project.

- **Run the following command to clean and build the application:**
  ```bash
  gradlew clean build

### Linux
Open a terminal.
Navigate to the root directory of the project.
- **Ensure the Gradle Wrapper has execution permissions:**:
  ```bash
  chmod +x gradlew
  
- **Run the following command to clean and build the application:**
  ```bash
  sudo ./gradlew clean build

## Running the Application
- **If you are running the application locally and do not need the deployed environment settings, you will need to comment out the following lines in the docker-compose.yml file:**
  ```bash
  version: '3.8'
  services:
    service:
      build: 
        context: .
        dockerfile: Dockerfile
      ports:
        - 8083:8083
  #    labels:
  #      - traefik.enable=true
  
  #    environment:
  #      - swagger.server.url=https://service.spacecraftEvents.imertetsu.me/api
  #    networks:
  #      - traefik_network

  #networks:
  #  traefik_network:
  #    external: true
- **Once the .jar file is generated, you can run the application by executing the following command:**
  ```bash
    docker-compose up -d

## Additional Information
- OpenAPI Documentation: The application includes OpenAPI documentation, which can be accessed at /swagger-ui.html once the application is running. example "http://localhost:8083/api/swagger-ui/index.html"
- Docker Support: The application includes Docker support with a docker-compose.yml file to manage the environment variables, including swagger.server.url.
- Traefik for HTTPS and Domain Management: Traefik is used in the application to handle domain routing and HTTPS management for the deployed environment.
