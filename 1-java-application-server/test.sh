#!/bin/bash
i=0
while true
do 
    printf "http://localhost/app/test/$i = "
    curl http://localhost/app/test/$i
    printf "\n"
    let i=$i+1;
    sleep 1
done