package createClasses.app;

import createClasses.app.http.HttpRequest;
import createClasses.app.http.HttpRequestImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    private static BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<String> validUrls = getValidUrls();
        String request = getRequest();

        HttpRequest httpRequest = new HttpRequestImpl(request);
    }

    private static List<String> getValidUrls() throws IOException {
        List<String> validUrls = new ArrayList<>();
        Arrays.stream(reader.readLine().split("\\s+")).forEach(url -> {
            validUrls.add(url);
        });

        return validUrls;
    }

    private static String getRequest() throws IOException {
        StringBuilder request = new StringBuilder();

        String line;

        while ((line = reader.readLine()) != null && !line.isEmpty()){
            request.append(line).append(System.lineSeparator());
        }

        request.append(System.lineSeparator());
        if ((line = reader.readLine()) != null && !line.isEmpty()){
            request.append(line);
        }

        return request.toString();
    }

    private static boolean urlIsValid(List<String> validUrls, HttpRequest httpRequest) {
        if (validUrls.contains(httpRequest.getRequestUrl())) {
            return true;
        }

        return false;
    }
}
