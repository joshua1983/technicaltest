FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
RUN mkdir -p /app/
ADD build/libs/*.jar /app/pruebatecnica.jar
ENTRYPOINT ["java","-jar","/app/pruebatecnica.jar"]
