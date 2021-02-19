FROM openjdk:11
ADD servidor_zuul.jar /apps/servidor_zuul.jar
ENV hosteureka 192.168.2.246
ENV port 8090
EXPOSE $port
ENTRYPOINT ["java","-jar","/apps/servidor_zuul.jar"]
