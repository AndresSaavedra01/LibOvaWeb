FROM openjdk:21-slim

RUN apt-get update && apt-get install -y openssh-client && rm -rf /var/lib/apt/lists/*

RUN mkdir -p /root/.ssh && ssh-keyscan 3.138.123.82 >> /root/.ssh/known_hosts

VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/LibOvaWeb-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
COPY libovaweb.so /usr/local/lib/jni/
COPY id_rsa.pem .
ENV LD_LIBRARY_PATH=/usr/local/lib/jni:$LD_LIBRARY_PATH
ENTRYPOINT ["java", "-jar", "app.jar"]
