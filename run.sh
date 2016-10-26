#!/usr/bin/env bash

mvn clean install

#cd support/discovery-server
#mvn spring-boot:run
#cd services/author-service

cd  support/discovery-server
mvn spring-boot:run &
cd services/author-service
mvn spring-boot:run &
