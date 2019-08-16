FROM java:8
COPY build/libs/*.jar /var/www/java/
WORKDIR /var/www/java
CMD ["java","-jar","merchantgalaxy-1.0-SNAPSHOT.jar"]