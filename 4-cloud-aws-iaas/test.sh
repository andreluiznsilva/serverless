#!/bin/bash
i=0
while true
do 
    printf "http://serverless-elb-1307573638.us-east-1.elb.amazonaws.com/test/$i = "
    curl http://serverless-elb-1307573638.us-east-1.elb.amazonaws.com/test/$i
    printf "\n"
    let i=$i+1;
    sleep 1
done



