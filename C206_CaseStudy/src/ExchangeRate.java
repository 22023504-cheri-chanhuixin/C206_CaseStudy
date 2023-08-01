public class ExchangeRate extends Currency {
    private double exchangeRate;

    public ExchangeRate(String currency, String name, double exchangeRate) {
        super(currency, name);
        this.exchangeRate = exchangeRate;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return super.toString() + " Exchange Rate: " + exchangeRate;
    }

    // Sample main method to create and display three currencies with exchange rates
    public static void main(String[] args) {
        // Create three sample currencies with exchange rates
        ExchangeRate usdCurrency = new ExchangeRate("USD", "United States Dollar", 1.0);
        ExchangeRate eurCurrency = new ExchangeRate("EUR", "Euro", 0.85);
        ExchangeRate sgdCurrency = new ExchangeRate("SGD", "Singapore Dollar", 1.35);

        // Display the details of the currencies with exchange rates
        System.out.println(usdCurrency);
        System.out.println(eurCurrency);
        System.out.println(sgdCurrency);
    }
}
