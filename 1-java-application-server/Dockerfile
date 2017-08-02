FROM jboss/wildfly:10.1.0.Final
ADD ./module.xml /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/module.xml
ADD ./target/lib/mysql-connector-java-*.jar /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/mysql.jar
ADD ./standalone.xml /opt/jboss/wildfly/standalone/configuration/standalone.xml
ADD ./target/*.war /opt/jboss/wildfly/standalone/deployments/app.war