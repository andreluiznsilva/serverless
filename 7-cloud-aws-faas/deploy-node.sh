#!/bin/bash

rm -rf target

mkdir -p target

npm install

zip -r target/app.zip node_modules index.js

aws lambda update-function-code --function-name NodeLambdaFunction --zip-file fileb://target/app.zip