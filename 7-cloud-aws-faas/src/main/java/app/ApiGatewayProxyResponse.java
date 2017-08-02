package app;

import java.util.HashMap;
import java.util.Map;

public class ApiGatewayProxyResponse {

    private int                 statusCode;
    private Map<String, String> headers = new HashMap<>();
    private Object              body;
    private boolean             isBase64Encoded;

    public ApiGatewayProxyResponse() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Object getBody() {
        return body;
    }

    public boolean getIsBase64Encoded() {
        return isBase64Encoded;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public void setBase64Encoded(boolean isBase64Encoded) {
        this.isBase64Encoded = isBase64Encoded;
    }

}