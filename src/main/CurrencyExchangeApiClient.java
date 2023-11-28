package src.main;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyExchangeApiClient {
    private String apiKey;

    public CurrencyExchangeApiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public String convertCurrency(String fromCurrency, String toCurrency, double amount) {
        try {
            String urlString = String.format("https://api.api-ninjas.com/v1/convertcurrency?want=%s&have=%s&amount=%f", toCurrency, fromCurrency, amount);

            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("X-Api-Key", this.apiKey);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;

            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            JSONObject jsonResponse = new JSONObject(content.toString());
            double convertedAmount = jsonResponse.getDouble("new_amount");

            return String.format("%.2f %s are %.2f %s", amount, fromCurrency, convertedAmount, toCurrency);

        } catch (Exception e) {
            e.printStackTrace();
            return "Error while calculating exchange amount: " + e.getMessage();
        }

    }
}