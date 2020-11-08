package dk.vip.transmit;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

public class Transmission {
/*
    public String transmit(String expressionJson) {
        String[] result = new String[1];

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/protocolbroker/post"))
                .POST(BodyPublishers.ofString(expressionJson)).build();
        client.sendAsync(request, BodyHandlers.ofString()).thenApply(HttpResponse::body).thenAccept(s -> result[0] = s)
                .join();

        return result[0];
    }
*/
    public String transmit(String expressionJson, String path) {
        String[] result = new String[1];

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("\"" + path + "\""))
                .POST(BodyPublishers.ofString(expressionJson)).build();
        client.sendAsync(request, BodyHandlers.ofString()).thenApply(HttpResponse::body).thenAccept(s -> result[0] = s)
                .join();

        return result[0];
    }
}
