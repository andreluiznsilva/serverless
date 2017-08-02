#!/bin/bash

# remove stack 
docker stack rm caas

# remove registry service
docker service rm registry

# leave swarm
docker swarm leave --force
