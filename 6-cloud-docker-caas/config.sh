#!/bin/bash

docker service create --name registry --publish 5000:5000 registry:2

printf " http://aml:5000/v2/ = "
curl  http://aml:5000/v2/
printf "\n"