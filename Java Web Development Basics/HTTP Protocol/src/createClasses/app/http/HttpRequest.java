package createClasses.app.http;

import java.util.Map;

public interface HttpRequest {

    String getMethod();

    String getRequestUrl();

    Map<String, String> getHeaders();

    Map<String, String> getBodyParameters();

    boolean isResource();

    void setMethod(String method);

    void setRequestUrl(String requestUrl);

    void addHeader(String key, String value);

    void addBodyParameter(String key, String value);

}
