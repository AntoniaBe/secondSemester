package src;

public class Customer {

	private String customersName;
	private String customersNumber;

	 
	 

	public Customer(String customersName, String customersNumber)
	{
	  this.customersName = customersName;
	  this.customersNumber = customersNumber;
	 }
	    
//@ return 	The name of a customer.
	 public String getCustomersName()
	 {
	   return customersName;
	  }
	 
//@ return The number of a customer.
	 public String getCustomersNumber()
	 {
	   return customersNumber;
	  }

}
