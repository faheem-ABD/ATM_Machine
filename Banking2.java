import java.util.Scanner;
import java.util.LinkedList;


class Person {
    private String name;
    private int age;
    private int bank_balance;
    private int overdraft; // positive representation of overdraft value

    //constructor
    public Person(String n, int a, int od_val) 
    {
         this.name= n;
         this.age= a;
         this.bank_balance= 0;  // balance in SEK
         this.overdraft= od_val;  // +ve representation e.g. 10K kr
    }

    // A simple method to return the String
    public String getName() 
    {
       // Return the string to the calling program
        return (this.name);
    } 
   
   
    // Increase bank_balance by an amount 
    // Input:
    //         - amount, value in SEK to be deposited
    // Output:
    //         - nothing
    
    public void makeDeposit(int amount)
    {
       
        this.bank_balance= this.bank_balance + amount;
        //return( this.bank_balance);
    }
    
    // Decrease bank_balance by an amount 
    // Input:
    //         - amount, value in SEK to be deposited
    // Output:
    //         - returns current balance,
    // NOTE: Should bank balances be able to be negative????
    //       We have a problem with reporting that no change 
    //       was made in some circumstances.
    
    public boolean makeWithdrawal(int amount)
    {
		int provisional_balance;

		// check balance against overdraft
        provisional_balance= this.bank_balance - amount;

		if (provisional_balance > -overdraft) {
			// Set a bank balance on request
			this.bank_balance= provisional_balance;
			return( true );
		} else 
			return( false );

    }
  
    public int getBalance()
    {
        // Return bank_balance to calling program
        return (this.bank_balance);
    }  

}

public class Banking2 {
    
    // Uses methods provided by class Person to update instance variables in a
    // a customer record.
    
    public static void manageAccount(Person current_person)
    {
		// We need to read input from the user in this method.
        Scanner in_stream= new Scanner(System.in);

        int amount;
        int choice= 1;

        while( choice != 0 ) {
            System.out.println("\nChose an option from the menu!");
            System.out.println(" 0: exit manageAccount!");
            System.out.println(" 1: make deposit");
            System.out.println(" 2: make withdrawal");
            System.out.println(" 3: get balance");
            System.out.println(" Select an option: ");
            
            choice= in_stream.nextInt();
            
            switch ( choice ) {
                case 0:
                    System.out.println("Exiting program");
		    break;
                case 1:
                    System.out.println("How much will you deposit? ");
                    amount= in_stream.nextInt();
                    current_person.makeDeposit(amount);
                    break;
                case 2:
                    System.out.println("How much will you withdraw? ");
                    amount= in_stream.nextInt();
                    current_person.makeWithdrawal(amount);
                    break;
                case 3:
                    System.out.println("Current balance is" + current_person.getBalance());  
                    break;
                default:
                    System.out.println("You entered an invalid choice you idiot!!!");  
                
             }
        }
    }

    // Handle creating and populating a new Person object instance
    // Inputs:
    //		- none
    // Outputs:
    //		- returns a Person 
    public static Person addCustomer()
    {
		int age, overdraft;
		String name;
        Scanner in_stream= new Scanner(System.in);


        System.out.println("Customer name: ");
        name= in_stream.next();
        System.out.println("Customer age: ");
        age= in_stream.nextInt();
        System.out.print("Customer overdraft: ");
        overdraft= in_stream.nextInt();

		return (new Person(name, age, overdraft));
    }

    public static void main(String[] argv)
    {

		// local variables for main menu
        int choice= 1;
		int pers_index= 0;
		int next_free= 0;

        // Create an inputstream from the keyboard
        Scanner in_stream= new Scanner(System.in);

	    // Create the database as a linked list
	    LinkedList<Person> bankCustomers = new LinkedList<Person>();

        while( choice != 0 ) {
            System.out.println("Main Menu");
            System.out.println(" 0: exit !");
            System.out.println(" 1: add customer record");
            System.out.println(" 2: manage customer account");
            System.out.println(" Option?");
            
            choice= in_stream.nextInt();
            
            switch ( choice ) {
                case 0:
                    System.out.println("Exiting program");
		    break;
                case 1: 
					// Create a new customer record
					//people_DB[next_free]= addCustomer();
					//next_free++;
					bankCustomers.add(addCustomer());
                    System.out.println(bankCustomers.size());
                    break;
                case 2:
                    System.out.println("Which customer?  ");
                    pers_index= in_stream.nextInt();

					manageAccount((Person)bankCustomers.get(pers_index));
                    break;
                default:
                    System.out.println("You entered an invalid choice you idiot!!!");  
            }
        }
    
    // Now we are done :-)
    }
}
