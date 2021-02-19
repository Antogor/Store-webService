FROM openjdk:11
ADD servidor_eureka.jar /apps/servidor_eureka.jar
ENV hosteureka 192.168.2.246
ENV port 8761
EXPOSE $port
ENTRYPOINT ["java","-jar","/apps/servidor_eureka.jar"]
