FROM eclipse-temurin:17-jdk-jammy AS build
WORKDIR /workspace
COPY pom.xml mvnw ./
COPY .mvn .mvn
COPY src src
RUN chmod +x mvnw && ./mvnw --batch-mode --no-transfer-progress package -DskipTests
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["sh","-c","exec java -XX:MaxRAMPercentage=75 -Dserver.port=${PORT:-8082} -jar app.jar"]
