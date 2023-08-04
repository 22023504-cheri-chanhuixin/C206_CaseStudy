import java.util.ArrayList;

public class Currency {
	private static String symbol;
	private String name;

	public Currency(String currency, String name) {
		this.symbol = symbol;
		this.name = name;

	}

	public static String getSymbol() {
		return symbol;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		String output = super.toString();
		output = String.format("%-63s %-20s", output, name, symbol);
		return output;
	}

	public static void viewAllCurrency(ArrayList<Currency> currencyList) {
		// TODO Auto-generated method stub
		
	}

	public static void setHeader(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setIsAvailable(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public boolean getIsAvailable() {
		// TODO Auto-generated method stub
		return false;
	}
}