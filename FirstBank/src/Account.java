import java.util.Scanner;

public class Account {
	// Class Variables
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;
	
	// Class constructor
	Account(String cName, String cID) {
		customerName = cName;
		customerID = cID; 
	}
	
	// Function for depositing money
	private void deposit(int amountOfMoney) {
		if (amountOfMoney != 0) {
			balance = balance + amountOfMoney;
			previousTransaction = amountOfMoney;
		}
	}
	
	// Function for withdrawing money
	private void withdraw(int amountOfMoney) {
		if (amountOfMoney != 0) {
			balance = balance - amountOfMoney;
			previousTransaction = -amountOfMoney;
		}
	}
	
	// Method showing the previous transaction
	private void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		}
		else if (previousTransaction < 0) {
			System.out.println("Withdrew: " + Math.abs(previousTransaction));
		}
		else {
			System.out.println("No transaction has occured");
		}
	}
	 
	// Function calculating interest of current funds after x number of years
	private void calculateInterest(int xYears) {
		double interestRate = .003;
		double newBalance = (balance * interestRate * xYears) + balance;
		System.out.println("The current interest rate is " + (100 * interestRate + "%"));
		System.out.println("After " + xYears + "years, your balance will be " + newBalance);
		
	}
	
	// Function showing the main menu
	void showMenu() {
		char option = '\0';
		Scanner scnr = new Scanner(System.in);
		System.out.println("Welcome, " + customerName + "!");
		System.out.println("Your ID is: " + customerID);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("A. Check your balance");
		System.out.println("B. Make a deposit");
		System.out.println("C. Make a withdrawal");
		System.out.println("D. View previous transaction");
		System.out.println("E. Calculate interest");
		System.out.println("F. Exit");
		System.out.println("G. Display my ID number");
		
		do {
		System.out.println();
		System.out.println("Enter an option: ");
		char option1 = scnr.next().charAt(0);
		option = Character.toUpperCase(option1);
		System.out.println();
		
		switch(option) {
		// Case 'A' allows the user to check their account balance
		case 'A':
			System.out.println("========");
			System.out.println("Balance = $" + balance);
			System.out.println("========");
			System.out.println();
			break; // To exit after done
		// Case 'B' allows the user to deposit money into their account
		case 'B':
			System.out.println("Enter amount to deposit: ");
			int amountOfMoney = scnr.nextInt();
			deposit(amountOfMoney);
			System.out.println();
			break;
		// Case 'C' allows the user to withdraw money
		case 'C':
			System.out.println("Enter an amount to withdraw: ");
			int amountOfMoney2 = scnr.nextInt();
			withdraw(amountOfMoney2);
			System.out.println();
			break;
		// Case 'D' allows the user to view their most recent transaction
		case 'D':
			System.out.println("========");
			getPreviousTransaction();
			System.out.println("========");
			System.out.println();
			break;
		// Case 'E' calculates the accrued interest on account after x # of years	
		case 'E':
			System.out.println("Enter how many years of accrued interest: ");
			int years = scnr.nextInt();
			calculateInterest(years);
			break;
		// Case 'F' exits the user from their account
		case 'F':
			System.out.println("========");
			break;
		// Case 'G' allows the user to have their user ID number displayed
		case 'G':
			System.out.println("Your user ID number is: " + customerID);
			break;
		
		// The default case let's the user know that they entered an invalid char
		default:
			System.out.println("Error: invalid option. Please enter A, B, C, D, E, F");
			break;
		
		}
	 } while (option != 'F');
	System.out.println("Thank you for banking with us!");
	}
		
	  

}