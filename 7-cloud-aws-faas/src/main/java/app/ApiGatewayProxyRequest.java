package app;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;

public class ApiGatewayProxyRequest {

    private String              resource;
    private String              path;
    private String              httpMethod;
    private Map<String, String> headers               = new HashMap<>();
    private Map<String, String> queryStringParameters = new HashMap<>();
    private Map<String, String> pathParameters        = new HashMap<>();
    private Map<String, String> stageVariables        = new HashMap<>();
    private Context             context;
    private String              body;
    private Boolean             isBase64Encoded;

    public String getResource() {
        return resource;
    }

    public String getPath() {
        return path;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, String> getQueryStringParameters() {
        return queryStringParameters;
    }

    public Map<String, String> getPathParameters() {
        return pathParameters;
    }

    public Map<String, String> getStageVariables() {
        return stageVariables;
    }

    public Context getContext() {
        return context;
    }

    public String getBody() {
        return body;
    }

    public boolean getIsBase64Encoded() {
        return isBase64Encoded;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setQueryStringParameters(Map<String, String> queryStringParameters) {
        this.queryStringParameters = queryStringParameters;
    }

    public void setPathParameters(Map<String, String> pathParameters) {
        this.pathParameters = pathParameters;
    }

    public void setStageVariables(Map<String, String> stageVariables) {
        this.stageVariables = stageVariables;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setBase64Encoded(Boolean base64Encoded) {
        isBase64Encoded = base64Encoded;
    }

}
