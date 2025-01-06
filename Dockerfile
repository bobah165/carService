FROM openjdk:17.0.1-jdk-slim
COPY build/libs/carService-1.0-SNAPSHOT.jar /app/carService.jar
EXPOSE 8001
CMD ["java", "-jar", "/app/carService.jar"]