#!/bin/bash
i=0
while true
do 
    printf "https://t0rodmo7hb.execute-api.us-east-1.amazonaws.com/node/test/$i = "
    curl https://t0rodmo7hb.execute-api.us-east-1.amazonaws.com/node/test/$i
    printf "\n"
    let i=$i+1;
    sleep 1
done



