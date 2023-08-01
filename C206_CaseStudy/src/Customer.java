
public class Customer {
	private String customer_balance;
	private Account id_p;
	
	
	public Customer(String cb, Account idp) {
		customer_balance = cb;
		id_p = idp;
		
	}
	public Customer(String cb, String acc_id, String acc_password) {
		customer_balance = cb;
		id_p = new Account(acc_id, acc_password);
	}

	public String getCustomer_balance() {
		return customer_balance;
	}
	public void setCustomer_balance(String customer_balance) {
		this.customer_balance = customer_balance;
	}
	public Account getId_p() {
		return id_p;
	}
	public void setId_p(Account id_p) {
		this.id_p = id_p;
	}
	public String toString(){
		String output = "";
		// Write your codes here
		return output;
	}
	
}

