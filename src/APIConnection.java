import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConnection {

    private final HttpClient client;
    private final String apiKey;
    private final String apiHost;

    public APIConnection () {
        client = HttpClient.newHttpClient();
        apiKey = "68ef94fabe9b8e0ee2f2fee9";
        apiHost = "https://v6.exchangerate-api.com/v6/";
    }
    private HttpRequest createRequest(String path) {
        return HttpRequest.newBuilder()
                .uri(URI.create(this.apiHost + apiKey + path))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
    }

    public String getExchangeRate(String fromCurrency, String toCurrency) {
        String option = "pair";
        String path =   "/" + option + "/" + fromCurrency + "/" + toCurrency;

        HttpRequest request = createRequest(path);
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println("Fallo en la Api: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}
