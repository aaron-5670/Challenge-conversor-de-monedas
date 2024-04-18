import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    public Conversiones divisa (String opcion) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/c57d14ef51946b4f5fef6eb5/latest/" + opcion);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion).build();

        try {
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversiones.class);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
