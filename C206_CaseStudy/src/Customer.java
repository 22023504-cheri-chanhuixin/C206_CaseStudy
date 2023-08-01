
public class Customer extends Account{
	private String customer_id;
	private int customer_age;
	
	public Customer (String account_id, double account_balance,String account_password,int customer_age) {
		super(account_id, account_balance, account_password);
		this.customer_id = customer_id;
		this.customer_age = customer_age;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public int getCustomer_age() {
		return customer_age;
	}

	public void setCustomer_age(int customer_age) {
		this.customer_age = customer_age;
	}

	public String toString(){
		String output = "";
		// Write your codes here
		return output;
	}
	
}

