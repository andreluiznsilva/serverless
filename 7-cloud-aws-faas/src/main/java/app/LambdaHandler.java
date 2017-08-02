package app;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * https://github.com/gabrielle-anderson/aws-lambda-proxy-java
 */
public class LambdaHandler implements RequestHandler<ApiGatewayProxyRequest, ApiGatewayProxyResponse> {

    private String url      = System.getenv("JDBC_DATABASE_URL");
    private String username = System.getenv("JDBC_DATABASE_USERNAME");
    private String password = System.getenv("JDBC_DATABASE_PASSWORD");

    @Override
    public ApiGatewayProxyResponse handleRequest(ApiGatewayProxyRequest request, Context context) {

        ApiGatewayProxyResponse response = new ApiGatewayProxyResponse();

        try {

            context.getLogger().log("test");

            String id = request.getPathParameters().get("id");

            TestPojo result = new TestPojo();

            result.setId(id);
            result.setText("Hello " + id);
            result.setDatetime(getDateTime());
            result.setIp(getIp());
            result.setHost(getHostName());

            response.setStatusCode(200);
            response.setBody(new ObjectMapper().writeValueAsString(result));

        } catch (Exception e) {
            response.setStatusCode(500);
            context.getLogger().log(e.getMessage());
        }

        return response;

    }

    private String getDateTime() {

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet = statement.executeQuery("SELECT NOW()");
                resultSet.next();
                return resultSet.getObject(1).toString();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    private String getIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

}
