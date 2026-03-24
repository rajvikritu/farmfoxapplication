# Use OpenJDK 17 Alpine image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the Spring Boot fat JAR into the container
ARG JAR_FILE=target/farmfoxapp-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} farmfoxapp.jar

# Expose the port your app will run on
EXPOSE 8080

# Run the JAR (profile will be passed at runtime if needed)
ENTRYPOINT ["java","-jar","/app/farmfoxapp.jar"]