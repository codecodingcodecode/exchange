package src.main;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        String configPath = System.getenv("CONFIG_PATH");
        if (configPath == null || configPath.isEmpty()) {
            throw new IllegalStateException("CONFIG_PATH is not set");
        }

        ConfigManager configManager = new ConfigManager(configPath);

        String apiKey = configManager.getPropertyValue("api_key");

        CurrencyExchangeApiClient apiClient = new CurrencyExchangeApiClient(apiKey);

        CurrencyExchange currencyExchange = new CurrencyExchange(apiClient);

        currencyExchange.performCurrencyExchange();
    }
}
