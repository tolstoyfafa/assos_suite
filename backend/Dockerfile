FROM maven:3.6.0 
MAINTAINER <AssosSuite@gmail.com>
WORKDIR /root
COPY . /root
COPY pom.xml /root
EXPOSE 8080
CMD ["mvn","spring-boot:run","-Dspring-boot.run.profiles=dev"]
