FROM openjdk:20
WORKDIR /app
COPY target/CEN4802-1.0-SNAPSHOT.jar app.jar
EXPOSE 3000
CMD ["java", "-jar", "app.jar"]