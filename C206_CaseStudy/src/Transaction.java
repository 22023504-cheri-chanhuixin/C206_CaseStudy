import java.util.Date;

public class Transaction extends User {
	private int transactionNo;
	private Date tDate;
	private int amount;
	private String desiredCurrency;
	public Transaction(String username, int userID, String password, String email, String role, int transactionNo,Date tDate, int amount, String desiredCurrency) {
		super(username,userID,password,email, role);
		this.transactionNo=transactionNo;
		this.tDate=tDate;
		this.amount=amount;
		this.desiredCurrency=desiredCurrency;
	
	}
	public int getTransactionNo() {
		return transactionNo;
	}
	public Date getTDate() {
		return tDate;
	}
	public int getAmount() {
		return amount;
	}
	public String getDesiredCurrency() {
		return desiredCurrency;
	}
	

}
