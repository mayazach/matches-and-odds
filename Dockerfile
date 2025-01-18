# Use an official Maven image as the base image
FROM maven:3.9.9-amazoncorretto-17-al2023 AS build
# Set the working directory in the container
WORKDIR /app
# Copy the pom.xml and the project files to the container
COPY pom.xml .
COPY src ./src
# Build the application using Maven
RUN mvn clean package -DskipTests
# Use an official amazoncorretto image as the base image
FROM amazoncorretto:17
# Set the working directory in the container
WORKDIR /app
# Copy the built JAR file from the previous stage to the container
COPY --from=build /app/target/match-odds-0.0.1-SNAPSHOT.jar .
# Set the command to run the application
CMD ["java", "-jar", "match-odds-0.0.1-SNAPSHOT.jar"]