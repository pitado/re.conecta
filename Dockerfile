# -------- FASE 1: BUILD --------
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app
COPY reconecta/ /app/
RUN apt-get update && apt-get install -y maven && mvn -B -DskipTests package

# -------- FASE 2: RUNTIME --------
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/reconecta-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Dserver.port=${PORT:-8080}","-jar","/app/app.jar"]
