#!/usr/bin/env bash

mvn clean install

call mvn -pl support/discovery-server -am spring-boot:run
call mvn -pl support/gateway-server -am spring-boot:run

#cd support/discovery-server
#mvn support/discovery-server/spring-boot:run &
#mvn support/gateway-server/spring-boot:run &
#cd services/author-service

#cd  support/discovery-server
#mvn spring-boot:run &
#cd services/author-service
#mvn spring-boot:run &
