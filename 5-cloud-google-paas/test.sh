#!/bin/bash
i=0
while true
do 
    printf "https://solid-justice-175012.appspot.com/test/$i = "
    curl https://solid-justice-175012.appspot.com/test/$i
    printf "\n"
    let i=$i+1;
    sleep 1
done