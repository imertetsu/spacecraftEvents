FROM openjdk:17-jdk-alpine

COPY build/libs/SpacecraftEvents-0.0.1.jar /app/

WORKDIR /app

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "SpacecraftEvents-0.0.1.jar"]