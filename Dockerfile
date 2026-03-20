# --- GIAI ĐOẠN 1: BUILD ---
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests


# --- GIAI ĐOẠN 2: RUN ---
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

# kích hoạt spring profile docker
ENV SPRING_PROFILES_ACTIVE=docker

ENTRYPOINT ["java","-jar","app.jar"]