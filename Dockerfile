# Use an official Maven image as the base image
FROM maven:3.9.9-amazoncorretto-17-al2023 AS build
# Set the working directory in the container
WORKDIR /app
# Copy the pom.xml and the project files to the container
COPY pom.xml .
COPY src ./src
# Build the application using Maven
RUN mvn clean package
# Use an official amazoncorretto image as the base image
FROM amazoncorretto:8u432-alpine3.17-jre
# Set the working directory in the container
WORKDIR /app
# Copy the built JAR file from the previous stage to the container
COPY --from=build /app/target/my-application.jar .
# Set the command to run the application
CMD ["java", "-jar", "my-application.jar"]