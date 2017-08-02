FROM tomcat:8.5-alpine
ADD ./target/lib/mysql-connector-java-*.jar /usr/local/tomcat/lib/mysql.jar
ADD ./target/*.war /usr/local/tomcat/webapps/app.war