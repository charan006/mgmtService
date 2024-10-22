# Step 1: Use an official JDK as a parent image
FROM eclipse-temurin:17-jdk-jammy

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the application JAR file from your local machine into the container
COPY target/*.jar app.jar

# Step 4: Expose the port that Spring Boot is running on
EXPOSE 8080

# Step 5: Set the entrypoint to run the application using Java
ENTRYPOINT ["java", "-jar", "app.jar"]
