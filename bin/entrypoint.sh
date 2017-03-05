#!/bin/bash

java -jar
  -Dslack.daocloud="$SLACK_DAOCLOUD" \
  -Dslack.microbadger="$SLACK_MICROBADGER" \
  $DATA_DIR/$APP_NAME/target/$APP_NAME.jar