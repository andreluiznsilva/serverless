#!/bin/bash
i=0
while true
do 
    printf "http://localhost:3000/test/$i = "
    curl http://localhost:3000/test/$i
    printf "\n"
    let i=$i+1;
    sleep 1
done

