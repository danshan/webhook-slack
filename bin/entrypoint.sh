#!/bin/bash

mvn sonar:sonar \
    -Dsonar.host.url=https://sonarqube.com \
    -Dsonar.organization=$SONAR_ORG\
    -Dsonar.login=$SONAR_TOKEN

java -jar \
  -Dslack.daocloud="$SLACK_DAOCLOUD" \
  -Dslack.microbadger="$SLACK_MICROBADGER" \
  -Dslack.docker="$SLACK_DOCKER" \
  -Dslack.sonar="$SLACK_SONAR" \
  $DATA_DIR/$APP_NAME/target/$APP_NAME.jar