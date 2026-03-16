FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /workspace

COPY pom.xml ./
COPY src ./src
RUN mvn -B -DskipTests clean package

FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=build /workspace/target/calculator-project-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-cp", "/app/app.jar", "Main"]

