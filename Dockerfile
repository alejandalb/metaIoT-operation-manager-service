# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the project files to the container
COPY . .

# Package the application
RUN ./mvnw package -DskipTests

# Expose the port the application runs on
EXPOSE 8080

# Set environment variables
ENV SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/metaIoT
ENV SPRING_DATASOURCE_USERNAME=op_manager
ENV SPRING_DATASOURCE_PASSWORD=meta
ENV SPRING_DATASOURCE_DRIVER_CLASS_NAME=com.mysql.cj.jdbc.Driver
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update
ENV MQTT_BROKER_URL=ws://mqtt-broker:9001
ENV MQTT_CLIENT_ID=op_manager
ENV MQTT_USERNAME=user
ENV MQTT_PASSWORD=12345
ENV MQTT_QOS=2
ENV MQTT_AUTO_RECONNECT=true
ENV MQTT_TOPICS_PUBLISH=op/publishments/
ENV MQTT_TOPICS_ACK=op/messages/+/ack/
ENV MQTT_TOPICS_COMPLETION=op/messages/+/completetion/
ENV MQTT_TOPICS_REJECTION=op/messages/+/rejection/

# Run the application
CMD ["java", "-jar", "target/operation-manager-service-0.0.1-SNAPSHOT.jar"]
