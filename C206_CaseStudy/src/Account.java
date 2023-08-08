
public class Account {
	private String account_id;
	private String account_password;
	private double account_balance;
	private String transaction_history;
	private String date;
	
	public Account(String acc_id, String acc_password) {
		account_id = acc_id;
		account_password = acc_password;
	}
	
	public Account (String account_id, String account_password, double account_balance, String transaction_history, String date) {
		this.account_id = account_id;
		this.account_password = account_password;
		this.account_balance = account_balance;
		this.transaction_history = transaction_history;
		this.date = date;
	}

	public String getAccount_id() {
		return account_id;
	}
	
	public String getAccount_password() {
		return account_password;
	}

	public void setAccount_password(String account_password) {
		this.account_password = account_password;
	}

	public double getAccount_balance() {
		return account_balance;
	}

	public String getTransaction_history() {
		return transaction_history;
	}

	public String getDate() {
		return date;
	}
	
}

