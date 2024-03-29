FROM openjdk:8
WORKDIR /app
COPY ./build/libs/chatapp-0.0.1-SNAPSHOT.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]