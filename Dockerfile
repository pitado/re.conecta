# -------- FASE 1: Build --------
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app
COPY . .
# Se o projeto tiver mvnw, use ele; senão instala maven e usa mvn
RUN if [ -f ./mvnw ]; then \
      chmod +x mvnw && ./mvnw -B -DskipTests package ; \
    else \
      apt-get update && apt-get install -y maven && mvn -B -DskipTests package ; \
    fi

# -------- FASE 2: Runtime --------
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/reconecta-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
# O Render fornece $PORT. Garantimos que o Spring use essa porta.
ENTRYPOINT ["java","-Dserver.port=${PORT:-8080}","-jar","/app/app.jar"]
