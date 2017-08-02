#!/bin/bash

aws cloudformation create-stack --stack-name serverless-vpc \
    --template-body file://cloudformation-vpc.yml \
    --capabilities CAPABILITY_IAM

aws cloudformation create-stack --stack-name serverless-rds \
    --template-body file://cloudformation-rds.yml \
    --capabilities CAPABILITY_IAM \
    --parameters  \
    ParameterKey=VPC,ParameterValue=vpc-adadd0d4 \
    ParameterKey=PrivateSubnet1,ParameterValue=subnet-cf543be3 \
    ParameterKey=PrivateSubnet2,ParameterValue=subnet-b6fadbfe \
    ParameterKey=PrivateSubnet3,ParameterValue=subnet-a783e4fd

aws cloudformation create-stack --stack-name serverless-lambda \
    --template-body file://cloudformation-lambda.yml \
    --capabilities CAPABILITY_IAM \
    --parameters  \
    ParameterKey=VPC,ParameterValue=vpc-adadd0d4 \
    ParameterKey=PublicSubnet1,ParameterValue=subnet-1156393d \
    ParameterKey=PublicSubnet2,ParameterValue=subnet-ddedcc95  \
    ParameterKey=PublicSubnet3,ParameterValue=subnet-b38cebe9 \
    ParameterKey=PrivateSubnet1,ParameterValue=subnet-cf543be3 \
    ParameterKey=PrivateSubnet2,ParameterValue=subnet-b6fadbfe \
    ParameterKey=PrivateSubnet3,ParameterValue=subnet-a783e4fd \
    ParameterKey=InternalAccessSecurityGroup,ParameterValue=sg-00fde171 \
    ParameterKey=RDSAccessSecurityGroup,ParameterValue=sg-05f1ed74 \
    ParameterKey=PublicNetworkAcl,ParameterValue=acl-8d8363f5