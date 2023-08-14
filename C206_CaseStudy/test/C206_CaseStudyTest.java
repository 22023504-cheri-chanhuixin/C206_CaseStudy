import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C206_CaseStudyTest {
	// prepare test data for user
	private User u1;
	private User u2;
	private User u3;
	  
	ArrayList<User> userList = new ArrayList<User>();
	
	// prepare test data for currency
	private Currency c1;
    private Currency c2;
    private Currency c3;
    private ArrayList<Currency> currencyList;
	
	// prepare test data for transaction
	private Transaction t1;
	private ArrayList<Transaction> transactionList;
	
	// prepare test data for account
	private Account a1;
	
	private ArrayList<Account> accountList;
	
	// prepare test data for rate
	private ExchangeRate er1;
    private ExchangeRate er2;
    private ExchangeRate er3;
    private ExchangeRate er4;
    private ArrayList<ExchangeRate> exchangeRateList;
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data for user
		u1 = new User("Danny", 1, "password001", "dan6@gmail.com", "Customer");
	    u2 = new User("Jon", 2, "", "jon567@gmail.com", "Customer");
	    u3 = new User("Eve", 3, "password003", "eve435gmail.com", "Customer");
	    
	    userList= new ArrayList<User>();
		
		// prepare test data for currency
		c1 = new Currency("USD", "United States Dollar");
        c2 = new Currency("EUR", "Euro");
        c3 = new Currency("MYR", "Malaysian Ringgit");

        currencyList = new ArrayList<>();
		
		// prepare test data for transaction
		 String sDate1="31/12/1998";  
	      Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
	      
	    
	    t1 = new Transaction("Timmy", 10, "pass","banana@gmail.com","customer",1, date1,200,"SGD");
	    transactionList= new ArrayList<Transaction>();
		
		// prepare test data for account
		a1 = new Account("A0011", "password11", 2000.00, "change 50SGD to USD", "12/3/2020");
		
		accountList = new ArrayList<Account>();
		
		// prepare test data for rate
		er1 = new ExchangeRate("USD", "United States Dollar", 0.74);
        er2 = new ExchangeRate("EUR", "Euro", 0.68);
        er3 = new ExchangeRate("MYR", "Malaysian Ringgit", 3.39);
        er4 = new ExchangeRate("JPY", "Japanese Yen", 106.81);
        
        exchangeRateList = new ArrayList<>(); // Initialize the exchangeRateList ArrayList
	}
	
	// user
	
	  @Test
	  public void testAddUser() {
	    //Check that there is a valid arrayList to add users
	    assertNotNull("Test that there is a valid User arrayList to add to", userList);
	    
	    //Test that 1 user has been added
	    C206_CaseStudy.addUser(userList, u1);
	    assertEquals("Test that arrayList size increased to 1", 1, userList.size());
	    assertSame("Check that User is successfully added into the system", u1,  userList.get(0));
	    
	    //Check that all information are filled
	    C206_CaseStudy.addUser(userList, u2);
	    boolean result = C206_CaseStudy.addUser(userList, u2);
	    assertFalse("Test that user with empty values are not added into the arrayList", result);
	    
	    //Check that the correct variables are entered
	    C206_CaseStudy.addUser(userList, u3);
	    assertNotEquals("Test that correct values are entered", 1, userList.size());
	  }
	    
	  
	  @Test
		public void testRetrieveAllUser() {
			// Test if user list is not null but empty - boundary
			assertNotNull("Test if there is valid User arraylist to add to", userList);

			// test if the list of users retrieved is empty -
			// boundary
			// Attempt to retrieve Users
			String allUser = C206_CaseStudy.retrieveAllUser(userList);
			String testOutput = "";

			assertEquals("Check that ViewAllUserlist", testOutput, allUser);

			// Given an empty list, after adding 2 users, test if the size of the list is
			// 2 - normal
			C206_CaseStudy.addUser(userList, u1);
			assertEquals("Test that User arraylist size is 1.", 1, userList.size());

			// test if the expected output string same as the list of users retrieved
			allUser = C206_CaseStudy.retrieveAllUser(userList);
			testOutput = String.format("%-25s %-25.2f %-25s %-25s %-25s\n", "A0011", 2000.00, "password11",
					"change 50SGD to USD", "12/3/2020");

			assertEquals("Test that ViewAllUserlist.", testOutput, allUser);
		}
	  
	  
	  @Test
	  public void testDoDeleteUser() {
	    //Test that there is a valid arrayLIst to delete users
	    assertNotNull("Test if there is valid User arraylist to add to", userList);
	    
	    //Test that user is successfully removed from the system
	    C206_CaseStudy.doDeleteUser(userList, u3.getUsername(), u3.getPassword());
	    assertEquals("Test thet userList removes user successfully", 0, userList.size());
	          
	    //Test that delete would be unsuccessful with incorrect values
	      C206_CaseStudy.addUser(userList, u1);
	      assertFalse(C206_CaseStudy.doDeleteUser(userList, "Dan", "password03"));
	      assertEquals("Test that the size of the arrayList remains the same", 1, userList.size());

	      //Check that if user does not exist in the system, they cannot be deleted 
	      assertFalse(C206_CaseStudy.doDeleteUser(userList, u2.getUsername(), u2.getPassword()));
	      assertEquals("Test that the size of the arrayList remains the same", 1, userList.size());
	  }
	
	// currency
	@Test
    public void testAddCurrency() {
        // Currency list is not null, so that can add a new currency - boundary
        assertNotNull("Check if there is valid Currency arraylist to add to", currencyList);
        
        // Given an empty list, after adding 1 currency, the size of the list is 1 - normal
        // The item just added is as same as the first item of the list
        C206_CaseStudy.addCurrency(currencyList, c1);
        assertEquals("Check that Currency arraylist size is 1", 1, currencyList.size());
        assertSame("Check that Currency is added", c1, currencyList.get(0));

        // Add another item. Test the size of the list is 2? - normal
        // The item just added is as same as the second item of the list
        C206_CaseStudy.addCurrency(currencyList, c2);
        assertEquals("Check that Currency arraylist size is 2", 2, currencyList.size());
        assertSame("Check that Currency is added", c2, currencyList.get(1));
        
        // Add an currency that already exists in the list - error
        C206_CaseStudy.addCurrency(currencyList, c3);
     	assertEquals("Test that the Currency arraylist size is the same.", 3, currencyList.size());

    }
	@Test
    public void testRetrieveAllCurrency() {
    	
        // Test if Item list is not null but empty - boundary
        assertNotNull("Test if there is valid Currency arraylist to retrieve item", currencyList);

        // Test if the list of currency retrieved from the SourceCentre is empty - boundary
        String allCurrency = C206_CaseStudy.retrieveAllCurrency(currencyList);
        String testOutput = "";
        assertEquals("Check that ViewAllCurrencylist", testOutput, allCurrency);

        // Given an empty list, after adding 3 items, test if the size of the list is 3 - normal
        C206_CaseStudy.addCurrency(currencyList, c1);
        C206_CaseStudy.addCurrency(currencyList, c2);
        C206_CaseStudy.addCurrency(currencyList, c3);
        assertEquals("Test that Currency arraylist size is 3", 3, currencyList.size());

        // Test if the expected output string same as the list of currencies retrieved from the SourceCentre
        allCurrency = C206_CaseStudy.retrieveAllCurrency(currencyList);
        testOutput = String.format("%-10s %-30s\n", "USD", "United States Dollar");
        testOutput = String.format("%-10s %-30s\n", "EUR", "Euro");
        testOutput = String.format("%-10s %-30s\n", "MYR", "Malaysian Ringgit");

        //assertEquals("Test that ViewAllCurrencylist", testOutput, allCurrency);

    }

    @Test
    public void testDoDeleteCurrency() {
        // Boundary
        assertNotNull("Check if there is valid currency arraylist to add to", currencyList);
        C206_CaseStudy.addCurrency(currencyList, c1);

        // Error
        boolean isDeleted = C206_CaseStudy.doDeleteCurrency(currencyList, "MYR");
        assertFalse("Check that available currency USD is deleted - false?", isDeleted);
        // Normal
        C206_CaseStudy.addCurrency(currencyList, c2);
        isDeleted = C206_CaseStudy.doDeleteCurrency(currencyList, "EUR");
        assertTrue("Check that deleted currency EUR is deleted - true", isDeleted);
        // Error
        isDeleted = C206_CaseStudy.doDeleteCurrency(currencyList, "JPY");
        assertFalse("Check that non-existing currency JPY is deleted - false?", isDeleted);
    }
	
	// transaction
	
	@Test
	  public void testAddTransaction() {
	    assertNotNull("Check if there is valid Transaction arraylist to add to", transactionList);
	    C206_CaseStudy.addTransaction(transactionList, t1);
	    assertEquals("Check that Transaction arraylist size is 1", 1, transactionList.size());
	    assertSame("Check that Transaction is added", t1, transactionList.get(0));
	  }
	
	@Test
    public void testRetrieveAllTransactions() {
      assertNotNull("Check if there is valid Transaction arraylist to add to", transactionList);
      String allTransaction= C206_CaseStudy.retrieveAllTransactions(transactionList);
      String testOutput = "";
      assertEquals("Check that ViewAllTransaction", testOutput, allTransaction);
      C206_CaseStudy.addTransaction(transactionList, t1);
      assertEquals("Test that Transaction arraylist size is 1", 1, transactionList.size());
      allTransaction= C206_CaseStudy.retrieveAllTransactions(transactionList);
      String sDate1="31/12/1998";  
      testOutput = String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n","Timmy", 10, "pass","banana@gmail.com","customer",1, sDate1,200,"SGD");
      assertEquals("Test that ViewAllTransaction", testOutput, allTransaction);
    }
	
	@Test
	  public void testDeleteTransaction() {
	    assertNotNull("Check if there is a valid array list to delete from", transactionList);
	    C206_CaseStudy.addTransaction(transactionList, t1);
	    C206_CaseStudy.doDeleteTransaction(transactionList, 1,"pass");
	    assertEquals("Test if the transaction is deleted.", 0,transactionList.size());
	  }
	
	// account
	
	@Test
	public void testAddAccount() {
		// account list is not null, so that can add a new account - boundary
		assertNotNull("Test if there is valid Account arraylist to add to", accountList);

		//Given an empty list, after adding 1 account, the size of the list is 1 - normal
		C206_CaseStudy.addAccount(accountList, a1);		
		assertEquals("Test that the Account arraylist size is 1.", 1, accountList.size());
		//The account just added is as same as the last account in the list
		assertSame("Test that Account is added to the end of the list.", a1, accountList.get(0));
		
		// Add an account that already exists in the list - error
		C206_CaseStudy.addAccount(accountList, a1);
		assertEquals("Test that the Account arraylist size is unchange.", 1, accountList.size());

		// Add an account that has missing detail - error
		Account a_missing = new Account("A0012", "", 1000.00, "change 150SGD to EUR", "23/5/2021");
		C206_CaseStudy.addAccount(accountList, a_missing);
		assertEquals("Test that the Account arraylist size is unchange.", 1, accountList.size());
	}
	
	@Test
	public void testRetrieveAllAccount() {
		//Test Case 1
		// Test if account list is not null but empty - boundary
		assertNotNull("Test if there is valid Account arraylist to add to", accountList);
		
		//test if the list of accounts retrieved from the SourceCentre is empty - boundary
		// Attempt to retrieve the Account 
		String allAccount = C206_CaseStudy.retrieveAllAccount(accountList);
		String testOutput = "";

		assertEquals("Check that ViewAllAccountlist", testOutput, allAccount);

		//Test Case 2
		//Given an empty list, after adding 2 accounts, test if the size of the list is 2 - normal
		C206_CaseStudy.addAccount(accountList, a1);
		assertEquals("Test that Account arraylist size is 1.", 1, accountList.size());
		
		//test if the expected output string same as the list of accounts retrieved from the SourceCentre	
		allAccount = C206_CaseStudy.retrieveAllAccount(accountList);
		testOutput = String.format("%-25s %-25.2f %-25s %-25s %-25s\n", "A0011", 2000.00, "password11", "change 50SGD to USD", "12/3/2020");
		
		assertEquals("Test that ViewAllAccountlist.", testOutput, allAccount);
	}
	
	@Test
	public void testDoDeleteAccount() {
		//boundary
		assertNotNull("Test if there is valid Account in the arraylist to delete from", accountList);
		//normal
		C206_CaseStudy.doDeleteAccount(accountList, "A0011", "password11");
		Boolean ok = C206_CaseStudy.doDeleteAccount(accountList, "A0011", "password11");
		assertEquals("Test that account arraylist size is 0.", 0, accountList.size());
		//error condition
		ok = C206_CaseStudy.doDeleteAccount(accountList, "A0011", "password11");
		assertFalse("Test if the same account is NOT ok to delete again?", ok);	
		//error condition
		ok = C206_CaseStudy.doDeleteAccount(accountList, "A0012", "password12");
		assertFalse("Test that non-existing account is NOT ok to delete?", ok);
			
	}
	
	// rate
	@Test
    public void testAddExchangeRate() {
        // Item list is not null, so that can add a new exchange rate - boundary
        assertNotNull("Check if there is valid ExchangeRate arraylist to add to", exchangeRateList);
        // Given an empty list, after adding 1 item, the size of the list is 1 - normal
        // The item just added is as same as the first item of the list
        C206_CaseStudy.addExchangeRate(exchangeRateList, er1);
        assertEquals("Check that ExchangeRate arraylist size is 1", 1, exchangeRateList.size());
        assertSame("Check that ExchangeRate is added", er1, exchangeRateList.get(0));

        // Add another item. Test the size of the list is 2? - normal
        // The item just added is as same as the second item of the list
        C206_CaseStudy.addExchangeRate(exchangeRateList, er2);
        assertEquals("Check that ExchangeRate arraylist size is 2", 2, exchangeRateList.size());
        assertSame("Check that ExchangeRate is added", er2, exchangeRateList.get(1));
    }

	@Test
    public void testRetrieveAllExchangeRates() {
        // Test if Item list is not null but empty - boundary
        assertNotNull("Test if there is valid ExchangeRate arraylist to retrieve item", exchangeRateList);

        // Test if the list of exchange rates retrieved from the ExchangeRateMain is empty - boundary
        String allExchangeRates = C206_CaseStudy.retrieveAllExchangeRates(exchangeRateList);
        String testOutput = "";
        assertEquals("Check that ViewAllExchangeRatesList", testOutput, allExchangeRates);

        // Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
        C206_CaseStudy.addExchangeRate(exchangeRateList, er1);
        C206_CaseStudy.addExchangeRate(exchangeRateList, er2);
        assertEquals("Test that ExchangeRate arraylist size is 2", 2, exchangeRateList.size());

        // Test if the expected output string same as the list of exchange rates retrieved from the ExchangeRateMain
        allExchangeRates = C206_CaseStudy.retrieveAllExchangeRates(exchangeRateList);
        testOutput = String.format("%-10s %-30s %-10.2f%n", "USD", "United States Dollar", 0.74);
        testOutput += String.format("%-10s %-30s %-10.2f%n", "EUR", "Euro", 0.68);

        //assertEquals("Test that ViewAllExchangeRatesList", testOutput, allExchangeRates);
    }
 @Test
    public void deleteExchangeRate() {
	// Normal Test: Check if there is a valid exchange rate ArrayList to add to
        assertNotNull("Check if there is a valid exchange rate arraylist to add to", exchangeRateList);
     // Normal Test: Adding exchange rates to the list
        C206_CaseStudy.addExchangeRate(exchangeRateList, er1);
        C206_CaseStudy.addExchangeRate(exchangeRateList, er2);
        
        boolean isDeleted = C206_CaseStudy.doDeleteExchangeRate(exchangeRateList, "USD");
        assertTrue("Check that deleted exchange rate USD is deleted - true", isDeleted);
        assertEquals("Check that ExchangeRate arraylist size is 1 after deletion", 1, exchangeRateList.size());
        assertSame("Check that remaining ExchangeRate is the same as the second item", er2, exchangeRateList.get(0));
     // Boundary Test: Delete exchange rate from an empty list
        isDeleted = C206_CaseStudy.doDeleteExchangeRate(exchangeRateList, "EUR");
        assertTrue("Check that deleted exchange rate EUR is deleted - true", isDeleted);
        assertEquals("Check that ExchangeRate arraylist size is 0 after deletion", 0, exchangeRateList.size());
     // Error Test: Delete non-existing exchange rate "JPY"
        isDeleted = C206_CaseStudy.doDeleteExchangeRate(exchangeRateList, "JPY");
        assertFalse("Check that non-existing exchange rate JPY is not deleted - false", isDeleted);
    }
    
	@After
	public void tearDown() throws Exception {
		// user
		u1 = null;
	    u2 = null;
	    u3 = null;
	    userList = null;
		
		// currency
		c1 = null;
        c2 = null;
        currencyList = null;
		
		// transaction
		 t1 = null;
		 transactionList = null;
		
		// account
		a1 = null;
		accountList = null;
		
		// rate
		er1 = null;
        er2 = null;
        er3 = null;
        er4 = null;
        exchangeRateList = null;
	}
	
	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
}