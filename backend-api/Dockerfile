# Stage 1: Build the application using Gradle
FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /app
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Fix Windows line endings for the Gradle wrapper
RUN sed -i 's/\r$//' gradlew 
RUN chmod +x gradlew

# Copy source code and build the executable JAR
COPY src src
RUN ./gradlew bootJar

# Rename the generated file to a standard name so it is easy to copy
RUN mv build/libs/*SNAPSHOT.jar build/libs/app.jar

# Stage 2: Run the application
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]