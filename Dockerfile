FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /project
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN ./mvnw package -DskipTests

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
ARG JAR_FILE=/project/target/*.jar
COPY --from=builder ${JAR_FILE} app.jar
RUN addgroup -S javauser && adduser -S -s /bin/false -G javauser javauser
RUN chown -R javauser:javauser /app
USER javauser
CMD "java" "-jar" "app.jar"