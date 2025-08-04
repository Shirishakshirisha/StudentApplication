# Use a valid Java 21 Alpine-based image
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the host into the container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 to allow outside access
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]






















# FROM openjdk:21-jdk-alpine

# WORKDIR /app

# COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# EXPOSE 8080

# ENTRYPOINT ["java", "-jar", "app.jar"]


