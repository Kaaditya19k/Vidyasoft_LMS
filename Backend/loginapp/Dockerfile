FROM amazoncorretto:17

WORKDIR /app

COPY . .

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/loginapp-0.0.1-SNAPSHOT.jar"]