#!/bin/sh

cd resource-highestbid

export TERM=${TERM:-dumb}

gradle -Dorg.gradle.native=false build

ls build/libs
cp build/libs/highestbid.jar ../resource-jar
cp Dockerfile ../resource-jar

