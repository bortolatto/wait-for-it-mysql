#!/bin/bash

echo "************************"
echo $ARTIFACT_NAME
echo "************************"
./wait && java -jar ${ARTIFACT_NAME}.jar