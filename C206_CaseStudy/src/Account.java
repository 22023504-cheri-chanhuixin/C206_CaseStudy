
public class Account {
	private String account_id;
	private String account_password;
	private double account_balance;
	private String transaction_history;
	private boolean isAccountFound;
	
	public Account(String acc_id, String acc_password) {
		account_id = acc_id;
		account_password = acc_password;
		this.isAccountFound = true;
	}
	
	public Account (String account_id, String account_password, double account_balance) {
		this.account_id = account_id;
		this.account_password = account_password;
		this.account_balance = account_balance;
		this.transaction_history = "";
		this.isAccountFound = true;
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
	
	public void setTransaction_history(String transaction_history) {
		this.transaction_history = transaction_history;
	}

	public boolean isAccountFound() {
		return isAccountFound;
	}

	public void setAccountFound(boolean isAccountFound) {
		this.isAccountFound = isAccountFound;
	}

}

