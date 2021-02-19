FROM openjdk:11
ADD microservicio_productos.jar /apps/microservicio_productos.jar
ENV hosteureka 192.168.2.246
ENV servidorBD 192.168.2.245:3306
ENV port 9000
EXPOSE $port
ENTRYPOINT ["java","-jar","/apps/microservicio_productos.jar"]
