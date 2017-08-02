#!/bin/bash

rm -rf target

mkdir -p target

cp ../3-java-embbed-server/target/java.embbed.server-1.0.0-SNAPSHOT.jar ./target/app.jar

touch ./target/run.sh
chmod +x ./target/run.sh 

echo '#!/bin/bash' >> ./target/run.sh
echo 'export JDBC_DATABASE_URL=jdbc:mysql://serverless-rds.csyw6tydma0b.us-east-1.rds.amazonaws.com:3306/app?createDatabaseIfNotExist=true&connectTimeout=10000' >> ./target/run.sh
echo 'export JDBC_DATABASE_USERNAME=app' >> ./target/run.sh
echo 'export JDBC_DATABASE_PASSWORD=app*1234' >> ./target/run.sh
echo 'nohup java -Dserver.port=80 -jar app.jar > app.log' >> ./target/run.sh

aws s3 cp ./target  s3://serverless-elb-deploy --recursive