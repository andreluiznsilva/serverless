#!/bin/bash

rm -rf target

mkdir -p target

mvn clean install

aws lambda update-function-code --function-name JavaLambdaFunction --zip-file fileb://target/cloud-aws-faas-1.0.0-SNAPSHOT.jar