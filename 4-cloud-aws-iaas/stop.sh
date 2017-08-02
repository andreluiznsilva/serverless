#!/bin/bash

aws cloudformation delete-stack --stack-name serverless-elb
aws cloudformation delete-stack --stack-name serverless-rds
aws cloudformation delete-stack --stack-name serverless-vpc