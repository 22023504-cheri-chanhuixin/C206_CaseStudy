public class Currency {
    private String currency;
    private String name;

    public Currency(String currency, String name) {
        this.currency = currency;
        this.name = name;

    }

    public String getCurrency() {
        return currency;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Currency: " + currency + " (" + name + ")";
    }

    // Sample main method to create and display three currencies
    public static void main(String[] args) {
        // Create three sample currencies
        Currency usdCurrency = new Currency("USD", "United States Dollar");
        Currency eurCurrency = new Currency("EUR", "Euro");
        Currency sgdCurrency = new Currency("SGD", "Sinagpore Dollar");

        // Display the details of the currencies
        System.out.println(usdCurrency);
        System.out.println(eurCurrency);
        System.out.println(sgdCurrency);
    }
}
