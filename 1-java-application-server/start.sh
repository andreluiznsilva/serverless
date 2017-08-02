#!/bin/bash

mvn clean install

docker-compose up --build

docker-compose logs -f

docker-compose down

docker-compose rm -f -v