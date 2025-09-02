# Multi-stage build for Spring Boot

FROM maven:3.9-eclipse-temurin-17 AS builder
WORKDIR /app

# Leverage Docker layer caching: first copy only pom.xml and resolve deps
COPY pom.xml ./
RUN mvn -q -e -DskipTests dependency:go-offline

# Copy source and build
COPY src ./src
RUN mvn -q -DskipTests package

FROM eclipse-temurin:17-jre
WORKDIR /app

# App port (Railway sets PORT; default 8080)
ENV PORT=8080

# Copy built jar
COPY --from=builder /app/target/CourseManagementSystem-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Pass through DB env vars at runtime (Railway or docker run -e ...)
ENV DB_URL="jdbc:mysql://root:xdEJIfJfFRmNElRyWdslMPZTDcanZbdR@ballast.proxy.rlwy.net:33765/railway"
ENV DB_USER="root"
ENV DB_PASSWORD="xdEJIfJfFRmNElRyWdslMPZTDcanZbdR"

ENTRYPOINT ["java","-jar","/app/app.jar"]

