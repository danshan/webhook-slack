FROM maven:3.3.9-jdk-8
MAINTAINER Dan <i@shanhh.com>

ENV APP_USER webhook
ENV DATA_DIR /opt/data
ENV APP_NAME webhook-slack

RUN mkdir -p ${DATA_DIR}
RUN useradd ${APP_USER} -m
RUN chown -R ${APP_USER} ${DATA_DIR}

USER webhook

ADD . /opt/data/${APP_NAME}
WORKDIR /opt/data/${APP_NAME}
RUN mvn clean package
RUN java -jar target/${APP_NAME}.jar

