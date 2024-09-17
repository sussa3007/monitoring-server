# Base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the build file
COPY /build/libs/*.jar /app/monitoring.jar

# Expose the port the application runs on
EXPOSE 18189

# Define entrypoint
ENTRYPOINT ["java", "-jar", "/app/monitoring.jar", "--spring.profiles.active=dev"]