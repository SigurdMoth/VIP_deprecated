package dk.vip.client.persistence;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import dk.vip.client.domain.HeadTransmissionHandler;

public class TailTransmissionHandler implements HeadTransmissionHandler {

    @Override
    public String transmit(String expressionJson) {
        String[] result = new String[1];

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://postman-echo.com/get")).build();
        client.sendAsync(request, BodyHandlers.ofString()).thenApply(HttpResponse::body).thenAccept(s -> result[0] = s)
                .join();

        return result[0];
    }
}
