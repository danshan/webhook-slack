FROM maven:3.3.9-jdk-8
MAINTAINER Dan <i@shanhh.com>

ENV APP_USER webhook
ENV DATA_DIR /opt/data
ENV APP_NAME webhook-slack

RUN mkdir -p ${DATA_DIR}
RUN useradd ${APP_USER} -m

ADD . ${DATA_DIR}/${APP_NAME}
RUN chown -R ${APP_USER} ${DATA_DIR}

USER ${APP_USER}

WORKDIR ${DATA_DIR}/${APP_NAME}
RUN mvn clean package

ADD bin/entrypoint.sh ${DATA_DIR}/entrypoint.sh

ARG VCS_REF

LABEL org.label-schema.vcs-ref=$VCS_REF \
      org.label-schema.vcs-url="https://github.com/danshan/hubot-docker"

EXPOSE 8080
ENTRYPOINT ["/opt/data/entrypoint.sh"]
