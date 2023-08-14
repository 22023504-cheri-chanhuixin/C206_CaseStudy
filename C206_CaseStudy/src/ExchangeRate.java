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

  public Object getExchangeRate_code() {
    // TODO Auto-generated method stub
    return null;
  }

  public Object getExchangeRate_ExchangeRate() {
    // TODO Auto-generated method stub
    return null;
  }

  public Object getExchangeRate_name() {
    // TODO Auto-generated method stub
    return null;
  }
}