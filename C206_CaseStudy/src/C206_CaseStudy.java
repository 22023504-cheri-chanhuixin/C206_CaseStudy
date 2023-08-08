import java.util.ArrayList;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class C206_CaseStudy {
	
	private static final int USER_TYPE_USER = 1;
	private static final int USER_TYPE_ADMIN = 2;
	private static final int ITEM_TYPE_EXCHANGE_RATE = 1;
	private static final int OPTION_ADDUSER = 1;
	private static final int OPTION_VIEWUSER = 2;
	private static final int OPTION_DELETEUSER = 3;
	private static final int OPTION_ADDCURRENCY = 4;
	private static final int OPTION_VIEWCURRENCY = 5;
	private static final int OPTION_DELETECURRENCY = 6;
	private static final int OPTION_ADDATRANSACTION = 7;
	private static final int OPTION_VIEWTRANSACTION = 8;
	private static final int OPTION_DELETETRANSACTION = 9;
	private static final int OPTION_ADDACCOUNT = 10;
	private static final int OPTION_VIEWACCOUNT = 11;
	private static final int OPTION_DELETEACCOUNT = 12;
	private static final int OPTION_ADDRATE = 13;
	private static final int OPTION_VIEWRATE = 14;
	private static final int OPTION_DELETERATE = 15;
	private static final int OPTION_QUIT = 16;

	public static void main(String[] args) {
		
		// user arraylist
		ArrayList<Admin> adminList = new ArrayList<Admin>();
	    ArrayList<User> userList = new ArrayList<User>();

	    adminList.add(new Admin("Amy", 01, "password01", "amy123@gmail.com"));
	    adminList.add(new Admin("Bob", 02, "password02", "bob45@yahoo.com"));
	    userList.add(new User("Danny", 001, "password001", "dan6@gmail.com"));
	    userList.add(new User("Jon", 002, "password002", "jon567@gmail.com"));
		
		// currency arraylist
		ArrayList<Currency> currencyList = new ArrayList<Currency>();

        currencyList.add(new Currency("USD", "United States Dollar"));
        currencyList.add(new Currency("EUR", "Euro"));
        currencyList.add(new Currency("SGD", "Singapore Dollar"));
		
		// transaction arraylist
		ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
				
		// account arraylist
		ArrayList<Account> accountList = new ArrayList<Account>();
		
		accountList.add(new Account("A001", "password1", 5000.00, "change 50SGD to USD", "12/3/2020"));
		accountList.add(new Account("A002", "password2", 10000.00, "change 300SGD to EUR", "23/4/2021"));
		
		// rate arraylist
		ArrayList<ExchangeRate> exchangeRatesList = new ArrayList<>();
	       
		ArrayList<ExchangeRate> exchangeRateList = new ArrayList<ExchangeRate>();

        exchangeRateList.add(new ExchangeRate("USD", "United States Dollar", 0.74));
        exchangeRateList.add(new ExchangeRate("EUR", "Euro", 0.68));
        exchangeRateList.add(new ExchangeRate("MYR", "Malaysian Ringgit", 3.39));
        exchangeRateList.add(new ExchangeRate("JPY", "Japanese Yen", 106.28));
		
		int option = 0;
		
		while (option != OPTION_QUIT) {
			
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == OPTION_ADDUSER) {
				// Add a new user
				C206_CaseStudy.setHeader("ADD USER TYPE");
		        System.out.println("1. User");
		        System.out.println("2. Admin");

		        int userType = Helper.readInt("Enter option to select user type > ");

		        if (userType == USER_TYPE_USER) {
		          User user = addUser(userList);
		          C206_CaseStudy.addUser(userList, user);
		          System.out.println("User added!");

		        } else if (userType == USER_TYPE_ADMIN) {
		          Admin admin = addAdmin(adminList);
		          C206_CaseStudy.addAdmin(adminList, admin);
		          System.out.println("Admin added!");

		        } else {
		          System.out.println("Invalid type");
		        }
				
			} else if (option == OPTION_VIEWUSER) {
				// View all users
				C206_CaseStudy.viewAllUser(userList);
		        C206_CaseStudy.viewAllAdmin(adminList);
			
			} else if (option == OPTION_DELETEUSER) {
				// delete a existing user
				C206_CaseStudy.setHeader("DELETE USER TYPES");
		        System.out.println("1. User");
		        System.out.println("2. Admin");
		        
		        int itemType = Helper.readInt("Enter option to select item type > ");
		        if (itemType == USER_TYPE_USER) {
		          C206_CaseStudy.returnUser(userList);
		        } else if (itemType == USER_TYPE_ADMIN) {
		          C206_CaseStudy.returnAdmin(adminList);
		        } else {
		          System.out.println("Invalid type");
		        }
				
			} else if (option == OPTION_ADDCURRENCY) {
				// Add a new currency
				C206_CaseStudy.setHeader("ADD CURRENCY");
	            Currency c = C206_CaseStudy.inputCurrency();
	            C206_CaseStudy.addCurrency(currencyList, c);
	            System.out.println("Currency added");
				
			} else if (option == OPTION_VIEWCURRENCY) {
				// View all currency
				C206_CaseStudy.viewAllCurrency(currencyList);
			
			} else if (option == OPTION_DELETECURRENCY) {
				// delete a existing currency
				C206_CaseStudy.setHeader("DELETE CURRENCY");
				C206_CaseStudy.viewAllCurrency(currencyList);
				C206_CaseStudy.deleteCurrency(currencyList);
			
			} else if (option == OPTION_ADDATRANSACTION) {
				// Add a new transaction
				C206_CaseStudy.setHeader("ADD");
		        Transaction t=inputTransactions();
		        C206_CaseStudy.addTransaction(transactionList,t);
		        System.out.println("Transaction added");
				
			} else if (option == OPTION_VIEWTRANSACTION) {
				// View all transactions
				C206_CaseStudy.viewAllTransactions(transactionList);
				
			} else if (option == OPTION_DELETETRANSACTION) {
				// delete a existing transaction
				C206_CaseStudy.setHeader("DELETE");
		        C206_CaseStudy.deleteTransaction(transactionList);
			
			} else if (option == OPTION_ADDACCOUNT) {
				// Add a new account
				C206_CaseStudy.setHeader("ADD");
				Account a = inputAccount();
				C206_CaseStudy.addAccount(accountList, a);
				System.out.println("Account added");

			} else if (option == OPTION_VIEWACCOUNT) {
				// View all accounts
				C206_CaseStudy.viewAllAccount(accountList);

			} else if (option == OPTION_DELETEACCOUNT) {
				// delete a existing account
				C206_CaseStudy.setHeader("DELETE");
				C206_CaseStudy.deleteAccount(accountList);
			
			} else if (option == OPTION_ADDRATE) {
				// Add a new exchange rate
				ExchangeRate exchangeRateAdd = inputExchangeRate();
                C206_CaseStudy.addExchangeRate(exchangeRatesList, exchangeRateAdd);
                System.out.println("Exchange rate added");
				
			} else if (option == OPTION_VIEWRATE) {
				// View all exchange rates
				C206_CaseStudy.viewAllExchangeRates(exchangeRatesList);
				
			} else if (option == OPTION_DELETERATE) {
				// delete a existing exchange rate
				C206_CaseStudy.deleteExchangeRate(exchangeRatesList);

			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			
			} else {
				System.out.println("Invalid option");
			}
		}
		
	}
	public static void menu() {
		C206_CaseStudy.setHeader("MONEY EXCHANGE");
		System.out.println("1. Add a new user");
		System.out.println("2. View all users");
		System.out.println("3. Delete an existing user");
		System.out.println("4. Add a new currency");
		System.out.println("5. View all currency");
		System.out.println("6. Delete an existing currency");
		System.out.println("7. Add a new transaction");
		System.out.println("8. View all transaction");
		System.out.println("9. Delete an existing transaction");
		System.out.println("10. Add a new account");
		System.out.println("11. View all accounts");
		System.out.println("12. Delete an existing account");
		System.out.println("13. Add a new rate");
		System.out.println("14. View all rate");
		System.out.println("15. Delete an existing rate");
		System.out.println("16. Quit");
		Helper.line(80, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	public static String showAvailability(boolean isAvailable) {
	    String avail;

	    if (isAvailable == true) {
	      avail = "Yes";
	    } else {
	      avail = "No";
	    }
	    return avail;
	  }
	
	//================================= Option 1 Add user (CRUD - Create) ========================================
	public static User addUser(ArrayList<User> userList) {
	    String username = Helper.readString("Enter username > ");
	    String password = Helper.readString("Enter password > ");
	    String contact = Helper.readString("Enter email > ");
	    int userID = userList.size();

	    User user = new User(username, userID, password, contact);
	    return user;

	  }
	public static void addUser(ArrayList<User> userList, User user) {
	    User item;
	    for (int i = 0; i < userList.size(); i++) {
	      item = userList.get(i);
	      if (item.getPassword().equalsIgnoreCase(user.getPassword()))
	        return;
	    }
	    if ((user.getUsername().isEmpty()) || (user.getContact().isEmpty())) {
	      return;
	    }
	    userList.add(user);

	  }

	  public static Admin addAdmin(ArrayList<Admin> adminList) {
	    String username = Helper.readString("Enter username > ");
	    String password = Helper.readString("Enter password > ");
	    String contact = Helper.readString("Enter email > ");
	    int userID = adminList.size();

	    Admin admin = new Admin(username, userID, password, contact);
	    return admin;

	  }

	  public static void addAdmin(ArrayList<Admin> adminList, Admin admin) {
	    Admin item;
	    for (int i = 0; i < adminList.size(); i++) {
	      item = adminList.get(i);
	      if (item.getUsername().equalsIgnoreCase(admin.getUsername()))
	        return;
	    }
	    if ((admin.getUsername().isEmpty()) || (admin.getContact().isEmpty())) {
	      return;
	    }

	    adminList.add(admin);

	  }
	
	//================================= Option 2 View user (CRUD - Read) =========================================
	  public static String retrieveAllUser(ArrayList<User> userList) {
		    String output = "";

		    for (int i = 0; i < userList.size(); i++) {

		      output += String.format("%-10s %-10d %-15s %-10s\n", userList.get(i).getUsername(),
		          userList.get(i).getUserID(), userList.get(i).getPassword(), userList.get(i).getContact());
		    }
		    return output;
		  }

		  public static void viewAllUser(ArrayList<User> userList) {
		    C206_CaseStudy.setHeader("USER LIST");
		    String output = String.format("%-10s %-10s %-15s %-10s\n", "USERNAME", "USERID", "PASSWORD", "CONTACT");
		    output += retrieveAllUser(userList);
		    System.out.println(output);
		  }

		  public static String retrieveAllAdmin(ArrayList<Admin> adminList) {
		    String output = "";
		    for (int i = 0; i < adminList.size(); i++) {

		      output += String.format("%-10s %-10d %-15s %-10s\n", adminList.get(i).getUsername(),
		          adminList.get(i).getUserID(), adminList.get(i).getPassword(), adminList.get(i).getContact());
		    }
		    return output;
		  }

		  public static void viewAllAdmin(ArrayList<Admin> adminList) {

		    C206_CaseStudy.setHeader("ADMIN LIST");
		    String output = String.format("%-10s %-10s %-15s %-10s\n", "USERNAME", "USERID", "PASSWORD", "CONTACT");
		    output += retrieveAllAdmin(adminList);
		    System.out.println(output);
		  }
	  
	//================================= Option 3 Delete user (CRUD - Delete) =====================================
		  public static boolean doDeleteUser(ArrayList<User> userList, String username, String password) {
			    boolean isDeleted = false;

			    for (int i = 0; i < userList.size(); i++) {
			    	if (userList.get(i).getUsername().equalsIgnoreCase(username)
			    	          && userList.get(i).getPassword().equalsIgnoreCase(password)) {
			    	        char confirm = Helper.readChar("Confirm Delete? (Y/ N) > ");
			    	        if (confirm == 'Y' || confirm == 'y') {
			    	          userList.remove(i);
			    	          isDeleted = true;

			    	        }
			    	      }
			    	    }
			    	    return isDeleted;
			    }
		  public static void returnUser(ArrayList<User> userList) {
			    C206_CaseStudy.viewAllUser(userList);
			    String username = Helper.readString("Enter username > ");
			    String password = Helper.readString("Enter password > ");
			    Boolean isDeleted = doDeleteUser(userList, username, password);

			    if (isDeleted == false) {
			      System.out.println("Invalid username");
			    } else {
			      System.out.println("User " + username + " deleted");
			    }
			    }
			  
			  public static boolean doDeleteAdmin(ArrayList<Admin> adminList, String username, String password) {
			    boolean isDeleted = false;

			    for (int i = 0; i < adminList.size(); i++) {

			      if (adminList.get(i).getUsername().equalsIgnoreCase(username)
			          && adminList.get(i).getPassword().equalsIgnoreCase(password)) {
			        char confirm = Helper.readChar("Confirm Delete? (Y/ N) > ");
			        if (confirm == 'Y' || confirm == 'y') {
			          adminList.remove(i);
			          isDeleted = true;

			        }
			      }
			    }
			    return isDeleted;

			  }

			  public static void returnAdmin(ArrayList<Admin> adminList) {
			    C206_CaseStudy.viewAllAdmin(adminList);
			    String username = Helper.readString("Enter username > ");
			    String password = Helper.readString("Enter password > ");
			    Boolean isDeleted = doDeleteAdmin(adminList, username, password);

			    if (isDeleted == false) {
			      System.out.println("Invalid username");
			    } else {
			      System.out.println("Admin " + username + " deleted.");
			    }
			  }			
		  
	//================================= Option 4 Add currency (CRUD - Create) ====================================
	public static Currency inputCurrency() {
        String code = Helper.readString("Enter currency code > ");
        String name = Helper.readString("Enter currency name > ");
        return new Currency(code, name);
    }
	public static void addCurrency(ArrayList<Currency> currencyList, Currency currency) {
        for (Currency c : currencyList) {
            if (c.getCode().equalsIgnoreCase(currency.getCode())) {
                System.out.println("Currency with the same code already exists.");
                return;
            }
        }
        currencyList.add(currency);
    }
	
	//================================= Option 5 View currency (CRUD - Read) =====================================
	public static void viewAllCurrency(ArrayList<Currency> currencyList) {
		C206_CaseStudy.setHeader("CURRENCY LIST");
        String output = String.format("%-10s %-30s\n", "CODE", "NAME");
        for (Currency currency : currencyList) {
            output += String.format("%-10s %-30s\n", currency.getCode(), currency.getName());
        }
        System.out.println(output);
    }
	
	//================================= Option 6 Delete currency (CRUD - Delete) =================================
	 public static void deleteCurrency(ArrayList<Currency> currencyList) {
	        String code = Helper.readString("Enter currency code to delete > ");
	        Currency currencyToRemove = null;
	        for (Currency currency : currencyList) {
	            if (currency.getCode().equalsIgnoreCase(code)) {
	                currencyToRemove = currency;
	                break;
	            }
	        }
	        if (currencyToRemove != null) {
	            currencyList.remove(currencyToRemove);
	            System.out.println("Currency with code " + code + " deleted");
	        } else {
	            System.out.println("Currency with code " + code + " not found.");
	        }
	    }
	
	//================================= Option 7 Add transaction (CRUD - Create) =================================
	 public static Transaction inputTransactions() {
		    
		    String un = Helper.readString("Enter Username > ");
		    int id = Helper.readInt("Enter user id > ");
		    String pw = Helper.readString("Enter password > ");
		    String c = Helper.readString("Enter contact number > ");
		    int tn=0;
		    tn++;
		    java.util.Date td= Helper.readDate("Enter date of transaction(dd/MM/yyyy)> ");
		    int a=Helper.readInt("Enter the amount you wish to exchange> ");
		    String dc=Helper.readString("Enter the currency you want to change into> ");
		    

		    Transaction t= new Transaction(un, id, pw,c,tn,td,a,dc);
		    
		    return t;
		    
		    
		  }
	public static void addTransaction(ArrayList<Transaction> transactionList, Transaction t) {
	    Transaction ts;
	    for(int i = 0; i < transactionList.size(); i++) {
	      ts = transactionList.get(i);
	      if (ts.getTransactionNo()==(ts.getTransactionNo()) )
	        return;
	    }
	    if ((t.getTransactionNo()==0) || (t.getPassword().isEmpty()) ) {
	      return;
	    }
	    transactionList.add(t);
	    
	  }
	
	//================================= Option 8 View transaction (CRUD - Read) =================================
	public static String retrieveAllTransactions(ArrayList<Transaction> transactionList) {
	    String output = "";
	    

	    for (int i = 0; i < transactionList.size(); i++) {
	      DateFormat tdf=new SimpleDateFormat("dd/MM/yyyy");
	      String strTD=tdf.format(transactionList.get(i).getTDate());
	    output += String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", transactionList.get(i).getUsername(),transactionList.get(i).getUserID(),transactionList.get(i).getPassword(),transactionList.get(i).getContact(),transactionList.get(i).getTransactionNo(),strTD,transactionList.get(i).getAmount(),transactionList.get(i).getDesiredCurrency());
	    
	      
	    }
	    return output;
	  }

	public static void viewAllTransactions(ArrayList<Transaction> transactionList) {
	    C206_CaseStudy.setHeader("TRANSACTION LIST");
	    String output = String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "USERNAME", "USERID",
	        "PASSWORD", "CONTACT","ROLE","TRANSACTION NO.","DATE","AMOUNT","CURRENCY");
	     output += retrieveAllTransactions(transactionList);  
	    System.out.println(output);
	  }
	
	//================================= Option 9 Delete transaction (CRUD - Delete) =================================
	public static boolean doDeleteTransaction(ArrayList<Transaction> transactionList, int id, String pw) {
	    
	    boolean isDeleted = false;

	    if (id==0 || pw.isEmpty())
	      return false;
	    
	    for (int i = 0; i < transactionList.size(); i++) {
	          
	      int Tid = transactionList.get(i).getTransactionNo();
	      int tid=Tid;
	      String Tpw=transactionList.get(i).getPassword();
	      String tpw=Tpw;
	      if((id==tid)&&(pw.equalsIgnoreCase(tpw))) {
	        isDeleted=true;
	        transactionList.remove(i);
	      }
	      
	    }
	    return isDeleted;
	  }
	public static void deleteTransaction(ArrayList<Transaction>transactionList) {
	    int id=Helper.readInt("Enter transaction id> ");
	    String pw=Helper.readString("Enter password> ");
	    Boolean isDeleted=doDeleteTransaction(transactionList,id,pw);
	    if(isDeleted==false) {
	      System.out.println("Transaction not found");
	    }
	    else {
	      System.out.println("Transaction deleted");
	    }
	  }
	
	//================================= Option 10 Add account (CRUD - Create) =================================
	public static Account inputAccount() {
		String acc_id = Helper.readString("Enter account id > ");
		String acc_password = Helper.readString("Enter account password > ");
		double acc_bal = Helper.readInt("Enter account balance > $");
		String trans_his = Helper.readString("Enter transaction history > ");
		String trans_date = Helper.readString("Enter transaction date > ");

		Account a = new Account(acc_id, acc_password,  acc_bal, trans_his, trans_date);
		return a;
		
	}
	public static void addAccount(ArrayList<Account> accountList, Account a) {
		Account customer;
		for(int i = 0; i < accountList.size(); i++) {
			customer = accountList.get(i);
			if (customer.getAccount_id().equalsIgnoreCase(a.getAccount_id()) )
				return;
		}
		if ((a.getAccount_id().isEmpty()) || (a.getAccount_password().isEmpty()) ) {
			return;
		}
		
		accountList.add(a);
	}
	
	//================================= Option 11 View account (CRUD - Read) =================================
	public static String retrieveAllAccount(ArrayList<Account> accountList) {
		String output = "";

		for (int i = 0; i < accountList.size(); i++) {
			output += String.format("%-25s %-25.2f %-25s %-25s %-25s\n", accountList.get(i).getAccount_id(), accountList.get(i).getAccount_balance(), accountList.get(i).getAccount_password(), accountList.get(i).getTransaction_history(), accountList.get(i).getDate());
			
		}
		return output;
	}
	
	public static void viewAllAccount(ArrayList<Account> accountList) {
		C206_CaseStudy.setHeader("ACCOUNT LIST");
		String output = String.format("%-25s %-25s %-25s %-25s %-25s\n", "ACCOUNT ID", "BALANCE", "ACCOUNT PASSWORD", "TRANSACTION HISTORY", "TRANSACTION DATE");
		 output += retrieveAllAccount(accountList);	
		System.out.println(output);
	}
	//================================= Option 12 Delete account (CRUD - Delete) =================================
	public static boolean doDeleteAccount(ArrayList<Account> accountList, String acc_id, String acc_password) {
		
		boolean isDeleted = false;
		
		if (acc_id.isEmpty() || acc_password.isEmpty())
			return false;
		
		for(int i = 0; i < accountList.size(); i++) {
			
			String account_id = accountList.get(i).getAccount_id();
			String accId = account_id;
			String account_password = accountList.get(i).getAccount_password();
			String accPassword = account_password;
			if ((acc_id.equalsIgnoreCase(accId)) && (acc_password.equalsIgnoreCase(accPassword))){
				isDeleted = true;
				accountList.remove(i);
		}
		}
		return isDeleted;
	}
	
	public static void deleteAccount(ArrayList<Account> accountList) {
		String acc_id = Helper.readString("Enter account id > ");
		String acc_password = Helper.readString("Enter account password > ");
		Boolean isDeleted = doDeleteAccount(accountList, acc_id, acc_password);
		if (isDeleted == false) {
			System.out.println("account not found");
		} else {
			System.out.println("account deleted");
		}
	}
	
	//================================= Option 13 Add rate (CRUD - Create) =================================
	public static ExchangeRate inputExchangeRate() {
        String code = Helper.readString("Enter exchange rate code > ");
        String name = Helper.readString("Enter exchange rate name > ");
        String exchangeRate = Helper.readString("Enter exchange rate  > ");
        return new ExchangeRate(code, name, 1);
    }

    public static void addExchangeRate(ArrayList<ExchangeRate> exchangeRateList, ExchangeRate exchangeRate) {
        for (ExchangeRate er : exchangeRateList) {
            if (er.getCode().equalsIgnoreCase(exchangeRate.getCode())) {
                System.out.println("Exchange rate with the same code already exists.");
                return;
            }
        }
        exchangeRateList.add(exchangeRate);
    }
	
	//================================= Option 14 View rate (CRUD - Read) =================================
    public static void viewAllExchangeRates(ArrayList<ExchangeRate> exchangeRateList) {
        C206_CaseStudy.setHeader("EXCHANGE RATE LIST : BASE CURRENCY 1 SGD");
        C206_CaseStudy.setHeader( "BUY/SELL 1 SGD");
        String output = String.format("%-15s %-20s %-10s\n", "CODE", "NAME", "EXCHANGE RATE");
        
        for (ExchangeRate exchangeRate : exchangeRateList) {
            output += String.format("%-15s %-20s %-10.2f\n", 
                                    exchangeRate.getCode(), 
                                    exchangeRate.getName(), 
                                    exchangeRate.getExchangeRate());
        }
        
        System.out.println(output);
    }
	
	//================================= Option 15 Delete rate (CRUD - Delete) =================================
    public static void deleteExchangeRate(ArrayList<ExchangeRate> exchangeRateList) {
        String code = Helper.readString("Enter exchange rate code to delete > ");
        ExchangeRate exchangeRateToRemove = null;
        for (ExchangeRate exchangeRate : exchangeRateList) {
            if (exchangeRate.getCode().equalsIgnoreCase(code)) {
                exchangeRateToRemove = exchangeRate;
                break;
            }
        }
        if (exchangeRateToRemove != null) {
            exchangeRateList.remove(exchangeRateToRemove);
            System.out.println("Exchange rate " + code + "code deleted");
        } else {
            System.out.println("Exchange rate " + code + "code not found.");
        }
    }
}

