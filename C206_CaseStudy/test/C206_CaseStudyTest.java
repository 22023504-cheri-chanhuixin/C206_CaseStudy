import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C206_CaseStudyTest {
	// prepare test data for user
	
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
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data for user
		
		// prepare test data for currency
		c1 = new Currency("USD", "United States Dollar");
        c2 = new Currency("EUR", "Euro");
        c3 = new Currency("MYR", "Malaysian Ringgit");

        currencyList = new ArrayList<>();
		
		// prepare test data for transaction
		 String sDate1="31/12/1998";  
	      Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
	      
	    
	    t1 = new Transaction("Timmy", 10, "pass","99998888",1, date1,200,"SGD");
	    transactionList= new ArrayList<Transaction>();
		
		// prepare test data for account
		a1 = new Account("A0011", "password11", 2000.00, "change 50SGD to USD", "12/3/2020");
		
		accountList = new ArrayList<Account>();
		
		// prepare test data for rate
	}
	
	// user
	
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
	    testOutput = String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n","Timmy", 10, "pass","99998888",1, sDate1,200,"SGD");
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

	@After
	public void tearDown() throws Exception {
		// user
		
		// currency
		c1 = null;
        c2 = null;
        currencyList = null;
		
		// transaction
		 t1=null;
		 transactionList = null;
		
		// account
		a1 = null;
		
		accountList = null;
		
		// rate
	}
	
	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
}