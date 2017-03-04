#!/bin/bash

java -jar -Dslack.daocloud="$SLACK_DAOCLOUD" $DATA_DIR/$APP_NAME/target/$APP_NAME.jar