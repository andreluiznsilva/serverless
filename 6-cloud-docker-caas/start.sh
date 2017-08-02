#!/bin/bash

# init swarn with this host as a node
docker swarm init

# create a loca registry 
docker service create --name registry --publish 5000:5000 registry:2

sleep 5

# build and publish the containers
docker-compose build
docker-compose push

# deploy the stack
docker stack deploy --compose-file docker-compose.yml caas