
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

class ExchangeRateResponse {

    private String result;
    private String documentation;
    private String terms_of_use;
    private long time_last_update_unix;
    private String time_last_update_utc;
    private long time_next_update_unix;
    private String time_next_update_utc;
    private String base_code;
    private Map<String, Double> conversion_rates;

    // Getters and setters

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getTerms_of_use() {
        return terms_of_use;
    }

    public void setTerms_of_use(String terms_of_use) {
        this.terms_of_use = terms_of_use;
    }

    public long getTime_last_update_unix() {
        return time_last_update_unix;
    }

    public void setTime_last_update_unix(long time_last_update_unix) {
        this.time_last_update_unix = time_last_update_unix;
    }

    public String getTime_last_update_utc() {
        return time_last_update_utc;
    }

    public void setTime_last_update_utc(String time_last_update_utc) {
        this.time_last_update_utc = time_last_update_utc;
    }

    public long getTime_next_update_unix() {
        return time_next_update_unix;
    }

    public void setTime_next_update_unix(long time_next_update_unix) {
        this.time_next_update_unix = time_next_update_unix;
    }

    public String getTime_next_update_utc() {
        return time_next_update_utc;
    }

    public void setTime_next_update_utc(String time_next_update_utc) {
        this.time_next_update_utc = time_next_update_utc;
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    // toString method for easier debugging and logging

    @Override
    public String toString() {
        return "ExchangeRateResponse{" +
                "result='" + result + '\'' +
                ", documentation='" + documentation + '\'' +
                ", terms_of_use='" + terms_of_use + '\'' +
                ", time_last_update_unix=" + time_last_update_unix +
                ", time_last_update_utc='" + time_last_update_utc + '\'' +
                ", time_next_update_unix=" + time_next_update_unix +
                ", time_next_update_utc='" + time_next_update_utc + '\'' +
                ", base_code='" + base_code + '\'' +
                ", conversion_rates=" + conversion_rates +
                '}';
    }
}

public class Main {
    private static String API_URL = "https://v6.exchangerate-api.com/v6/48b6464571ce6e8711a77f0d/latest/";
    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            try (Scanner sc = new Scanner(System.in)) {
                System.out.print("Input Currency: ");
                String input = sc.next();
                API_URL+=input;
                System.out.print("Output Currency: ");
                String output = sc.next();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI(API_URL))
                        .GET()
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String jsonString = response.body();
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    ExchangeRateResponse pojo = objectMapper.readValue(jsonString, ExchangeRateResponse.class);
                    System.out.println(pojo.getConversion_rates().get(output));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
