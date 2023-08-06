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
}