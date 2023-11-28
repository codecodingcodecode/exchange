import java.util.Scanner;

public class CurrencyExchange {

    private Scanner scanner;
    private String[] currencies;
    private CurrencyExchangeApiClient apiClient;

    public CurrencyExchange(CurrencyExchangeApiClient apiClient){
        this.scanner = new Scanner(System.in);
        this.apiClient = apiClient;
        this.currencies = new String[]{
                "USD - United States Dollar",
                "CAD - Canadian Dollar",
                "EUR - Euro",
                "JPY - Japanese Yen",
                "CNY - Chinese Yuan",
                "GBP - British Pound",
                "CHF - Swiss Franc",
                "NZD - New Zealand Dollar",
                "AUD - Australian Dollar",
                "KRW - South Korean Won",
                "PLN - Polish Zloty",
                "DKK - Danish Krone",
                "TRY - Turkish New Lira",
                "HKD - Hong Kong Dollar"
        };
    }

    public void performCurrencyExchange() {
        System.out.println("Provide the currency you have: ");

        for (int i = 0; i < currencies.length; i++){
            System.out.println((i + 1) + "." + currencies[i]);
        }

        System.out.println("Currency: ");

        int have = scanner.nextInt() - 1;

        if (have < 1 || have > currencies.length){
            System.out.println("Invalid Currency");
            return;
        }

        String haveCurrency = getCurrencyCode(currencies[have]);

        System.out.println("\nProvide the currency you want: ");

        for (int i = 0; i < currencies.length; i++){
            System.out.println((i + 1) + "." + currencies[i]);
        }

        System.out.println("Currency: ");

        int want = scanner.nextInt() - 1;

        if (want < 1 || want > currencies.length){
            System.out.println("Invalid Currency");
            return;
        }

        String wantCurrency = getCurrencyCode(currencies[want]);

        System.out.println("Provide the amount you want to exchange: ");

        double amount = scanner.nextDouble();

        String result = apiClient.convertCurrency(haveCurrency, wantCurrency, amount);
        System.out.println("Converted amount: " + result);

        scanner.close();
    }

    private String getCurrencyCode(String currencyString) {
        return currencyString.split(" - ")[0];
    }
}
