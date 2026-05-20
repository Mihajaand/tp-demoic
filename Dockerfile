# Image de base légère avec JRE 11
FROM eclipse-temurin:11-jre-alpine

LABEL maintainer="ENI-M2-DevOps"
LABEL description="Triangle App — TP2 Jenkins CI/CD"

WORKDIR /app

# Copier le jar construit par Maven
COPY target/triangle-app-1.5.0.jar triangle-app.jar

# Démarrer l'application
ENTRYPOINT ["java", "-jar", "triangle-app.jar"]
