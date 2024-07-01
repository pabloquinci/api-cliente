FROM openjdk:21-slim

LABEL mentainer="Backend Challenge - API Cliente"

WORKDIR /app

COPY target/api-cliente-0.0.1-SNAPSHOT.jar /app/api-cliente-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "api-cliente-0.0.1-SNAPSHOT.jar"]