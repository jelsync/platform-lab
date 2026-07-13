FROM eclipse-temurin:17-jre-jammy


LABEL org.opencontainers.image.title="platform-lab-java"
LABEL org.opencontainers.image.description="Aplicación Spring Boot del Platform Lab"
LABEL org.opencontainers.image.source="https://github.com/jelsync/platform-lab"

RUN apt-get update \
    && apt-get install -y --no-install-recommends curl ca-certificates \
    && rm -rf /var/lib/apt/lists/* \
    && groupadd --system app \
    && useradd --system --gid app --home-dir /app --shell /usr/sbin/nologin app

WORKDIR /app

COPY target/*.jar app.jar

RUN chown -R app:app /app

EXPOSE 8081

USER app

HEALTHCHECK --interval=30s --timeout=5s --start-period=60s --retries=3 \
    CMD curl -fsS http://localhost:8081/api/hola >/dev/null || exit 1

ENTRYPOINT ["java","-jar","/app/app.jar"]
