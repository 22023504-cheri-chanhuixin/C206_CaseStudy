
public class Account {
	private String account_id;
	private double account_balance;
	private String transaction_history;
	private String account_password;
	
	public Account (String account_id, double account_balance, String account_password) {
		this.account_id = account_id;
		this.account_balance = account_balance;
		this.transaction_history = transaction_history;
		this.account_password = account_password;
	}

	public String getAccount_id() {
		return account_id;
	}

	public double getAccount_balance() {
		return account_balance;
	}

	public String getTranscation_history() {
		return transaction_history;
	}

	public String getAccount_password() {
		return account_password;
	}

	public void setAccount_password(String account_password) {
		this.account_password = account_password;
	}	

}

