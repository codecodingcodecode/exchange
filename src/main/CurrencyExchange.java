package src.main;

import java.util.Scanner;

public class CurrencyExchange {
    private Scanner scanner;
    private String[] currencies;
    private CurrencyExchangeApiClient apiClient;

    public CurrencyExchange(CurrencyExchangeApiClient apiClient) {
        this.scanner = new Scanner(System.in);
        this.apiClient = apiClient;
        this.currencies = new String[]{"USD - United States Dollar", "CAD - Canadian Dollar", "EUR - Euro", "JPY - Japanese Yen", "CNY - Chinese Yuan", "GBP - British Pound", "CHF - Swiss Franc", "NZD - New Zealand Dollar", "AUD - Australian Dollar", "KRW - South Korean Won", "PLN - Polish Zloty", "DKK - Danish Krone", "TRY - Turkish New Lira", "HKD - Hong Kong Dollar"};
    }

    public void performCurrencyExchange() {
        System.out.println("Provide the currency you have: ");

        int have;
        for(have = 0; have < this.currencies.length; ++have) {
            System.out.println(have + 1 + "." + this.currencies[have]);
        }

        System.out.println("Currency: ");
        have = this.scanner.nextInt() - 1;
        if (have >= 1 && have <= this.currencies.length) {
            String haveCurrency = this.getCurrencyCode(this.currencies[have]);
            System.out.println("\nProvide the currency you want: ");

            int want;
            for(want = 0; want < this.currencies.length; ++want) {
                System.out.println(want + 1 + "." + this.currencies[want]);
            }

            System.out.println("Currency: ");
            want = this.scanner.nextInt() - 1;
            if (want >= 1 && want <= this.currencies.length) {
                String wantCurrency = this.getCurrencyCode(this.currencies[want]);
                System.out.println("Provide the amount you want to exchange: ");
                double amount = this.scanner.nextDouble();
                String result = this.apiClient.convertCurrency(haveCurrency, wantCurrency, amount);
                System.out.println("Converted amount: " + result);
                this.scanner.close();
            } else {
                System.out.println("Invalid Currency");
            }
        } else {
            System.out.println("Invalid Currency");
        }
    }

    private String getCurrencyCode(String currencyString) {
        return currencyString.split(" - ")[0];
    }
}
