FROM openjdk:8
WORKDIR /usr/src/app
COPY . .
RUN curl http://mirror.olnevhost.net/pub/apache/maven/maven-3/3.6.2/binaries/apache-maven-3.6.2-bin.tar.gz -o /usr/local/apache-maven-3.6.2-bin.tar.gz
RUN tar -C /usr/local -xvf /usr/local/apache-maven-3.6.2-bin.tar.gz
ENV PATH="/usr/local/apache-maven-3.6.2/bin:${PATH}"
