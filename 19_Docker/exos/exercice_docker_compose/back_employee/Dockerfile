FROM maven:3.6-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

ENV SPRING_PORT=${SPRING_PORT}

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

COPY --from=build /app/target/back_employee-0.0.1-SNAPSHOT.jar .

EXPOSE ${SPRING_PORT}

ENTRYPOINT ["java", "-jar", "back_employee-0.0.1-SNAPSHOT.jar"]
