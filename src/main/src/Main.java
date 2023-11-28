public class Main {
    public static void main(String[] args) {
        ConfigManager configManager = new ConfigManager("C:\\Users\\seanh\\OneDrive\\Dokumente\\Dokumente\\Priv_Projects\\exchange\\src\\main\\ressources\\config.properties");
        String apiKey = configManager.getPropertyValue("api_key");

        CurrencyExchangeApiClient apiClient = new CurrencyExchangeApiClient(apiKey);

        CurrencyExchange currencyExchange = new CurrencyExchange(apiClient);
        currencyExchange.performCurrencyExchange();
    }
}
