
public class Transaction extends User {
	private String tDate;
	private int amount;
	private String desiredCurrency;
	public Transaction(String username, String userID, String password, String contact, String role,String tDate, int amount, String desiredCurrency) {
		super(username,userID,password,contact,role);
		this.tDate=tDate;
		this.amount=amount;
		this.desiredCurrency=desiredCurrency;
	}
	public String tDate() {
		return tDate;
	}
	public int amount() {
		return amount;
	}
	public String desiredCurrency() {
		return desiredCurrency;
	}

}
