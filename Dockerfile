# -------- FASE 1: BUILD --------
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
# Copia apenas o módulo onde está o pom.xml e o código
COPY reconecta/ /app/
# Build silencioso, sem testes
RUN mvn -q -DskipTests clean package

# -------- FASE 2: RUNTIME --------
FROM eclipse-temurin:17-jre
WORKDIR /app
# O Maven gera /app/target/reconecta.jar (por causa do <finalName>reconecta</finalName>)
COPY --from=build /app/target/reconecta.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Dserver.port=${PORT:-8080}","-jar","/app/app.jar"]
