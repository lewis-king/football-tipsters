# Use the official gradle image to create a build artifact.
# https://hub.docker.com/_/gradle
FROM gradle:7.6.2-jdk17 AS build

# Set the current working directory inside the image
WORKDIR /app

# Copy the current directory contents into the container
COPY . .

# Build the application
RUN gradle clean build

FROM eclipse-temurin:17-jre-focal

# Copy the jar to the production image from the builder stage.
COPY --from=build /app/build/libs/*.jar /app.jar

# Run the web service on container startup.
CMD ["java", "-jar", "/app.jar"]
