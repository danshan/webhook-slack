#!/bin/bash

java -jar \
  -Dslack.daocloud="$SLACK_DAOCLOUD" \
  -Dslack.microbadger="$SLACK_MICROBADGER" \
  -Dslack.docker="$SLACK_DOCKER" \
  -Dslack.sonar="$SLACK_SONAR" \
  $DATA_DIR/$APP_NAME/target/$APP_NAME.jar