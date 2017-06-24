/*Ishvaraus Davis
CS 0007
Assignment Two*/
import java.util.Scanner;

public class Webstore
{
	public static void main(String[] args)
	{
		/**array declarations and initializations**/
		//TO-DO: initialize the itemNames array with the item names
		//(e.g. "eReader", "Java textbook", ...)
		String[] itemNames = {null,"eReader", "Java textbook", "Flash drive", "Netbook", "Python textbook", "Laptop PC", "Headphones", "Tablet PC", "Wireless keyboard", "Laptop briefcase"};
		
		//TO-DO: initialize the price array (e.g. 180.0, 85.0, ...)
		double[] priceArray = {180.00, 85.00, 12.00, 250.00, 95.00, 770.00, 55.00, 300.00, 60.00, 40.00};
		
		int[] shoppingCart = new int[10];
		//TO-DO: initialize the accountNumbers array
		//(e.g. "5658945", "4528125", ...)
		String[] accountNumbers = {"5658945", "4528125", "7805122", "8777521", "8751277", "1202850", "1005331", "6542231", "3812085", "7576631", "7981200", "4281002"};

		
		/**other variable declarations and initializations**/
		Scanner keyboard = new Scanner(System.in);
		int menuChoice = 0;
		String userName = "";
		int itemNumber;	//used to store item selection during "item add" operation
		int quantity = 0;	//used to store quantity during "item add" operation
		boolean cartIsEmpty = true;
		String userAccountNumber = "";	//used in the checkout operation
		boolean accountNumberIsValid = false;	//used in the checkout operation
		
		
		//print welcome message
		System.out.println("Welcome to the Java Web Store!");
		
		//start main program loop
		do
		{
			
			displayMenuOptions();
			
			//prompt the user to enter a menu option
			System.out.print("Please enter your selection: ");
			menuChoice = keyboard.nextInt();
			
			//use a switch statement to act based on the value of
			//menuChoice variable
			switch(menuChoice)
			{
				
				case 1:	//view item selection
					//TO-DO: write print statements to print the
					//item selections
					System.out.println("1. eReader\t\t $180.00");
					System.out.println("2. Java textbook\t $85.00");
					System.out.println("3. Flash drive\t\t $12.00");
					System.out.println("4. Netbook\t\t $250.00");
					System.out.println("5. Python textbook\t $95.00");
					System.out.println("6. Laptop PC\t\t $770.00");
					System.out.println("7. Headphones\t\t $55.00");
					System.out.println("8. Tablet PC\t\t $300.00");
					System.out.println("9. Wireless keyboard\t $60.00");
					System.out.println("10. Laptop briefcase\t $40.00\n\n");

					break;
				
				case 2:	//view shopping cart
					//first determine if the cart is empty
					//how to do this: assume cart is empty, and if we find
					//an entry > 0, infer that cart is non-empty
					//use the flag variable cartIsEmpty to keep track of this
					cartIsEmpty = true;
					for (int i = 0; i < shoppingCart.length; i++)
					{
						if (shoppingCart[i] > 0)
							cartIsEmpty = false;
					}
					
					//print a message if cart is empty
					if (cartIsEmpty == true)
						System.out.println("Your shopping cart is currently empty.\n\n");
					if (cartIsEmpty == false)
					{
						//print the title and table heading
						System.out.println("\n\nShopping Cart Contents:");
						System.out.printf("%-25s%-25s%10s\n", "Item", "Quantity", "Cost");
						
						//loop through the shoppingCart array and print a table row for
						//each item that has an entry > 0
						
						for (int i = 0; i < shoppingCart.length; i++)
						{
							if (shoppingCart[i] > 0)
							{
								//TO-DO: complete the print statement
								double Cost = priceArray[i - 1] * quantity;
								System.out.printf("%-25s%-25d$%10.2f\n", itemNames[i], shoppingCart[i], Cost);
							}
						}
					}
		
					break;
					
					case 3:	//add item to cart
						//prompt user for item number and quantity
						//TO-DO: prompt user for item number; store input in the
						//variable itemNumber
						System.out.println("Enter an item number: ");
						itemNumber = keyboard.nextInt();
						//TO-DO: prompt user for quantity; store input in the
						//variable quantity
						System.out.println("Enter the quantity: ");
						quantity = keyboard.nextInt();
						
						//TO-DO: update the shopping cart array
						shoppingCart[itemNumber] = quantity;
						
						//TO-DO: print a confirmation message to the user
						//e.g. "Added 4 Headphones to your cart."

						System.out.println("Added " + quantity + " " + itemNames[itemNumber] + " to your account");
						break;
					
					case 4:	//remove item from cart
						//prompt user for item number and quantity
						//TO-DO: prompt user for item number; store input in the
						//variable itemNumber
						System.out.println("Enter an item number: ");
						itemNumber = keyboard.nextInt();
						
						//TO-DO: prompt user for quantity; store input in the
						//variable quantity
						System.out.println("Enter the quantity: ");
						quantity = keyboard.nextInt();
						
						//perform remove operation if possible
						//the operation is not possible if, for the item, we have:
						//(quantity to remove) > (quantity in cart)
						
						//TO-DO: fill in the proper index for the shoppingCart array
						if (quantity > shoppingCart[itemNumber])
						{
							//TO-DO: fill in the proper index for the shoppingCart array and the itemNames array
							System.out.print("You have " + shoppingCart[0] + " " + itemNames[itemNumber] + " in your cart.  " +
											 "Nothing was removed.\n");
						}
						else
						{
							//perform remove operation and print confirmation message to user
							//TO-DO: remove the quantity from the proper element of the shoppingCart array
							shoppingCart[itemNumber] = quantity;
							
							
							//TO-DO: print a confirmation message to the user
							//e.g. "Removed 1 Headphones from your cart."
							System.out.println("Removed " + quantity + " " + itemNames[itemNumber] + " from your account");

							
						}
						
						break;
						
					case 5:	//checkout
						//prompt user to enter an account number; store input in variable userAccountNumber
						System.out.print("Please enter your account number to complete your order: ");
						userAccountNumber = keyboard.nextLine();
						
						//check if the account number is valid
						//how to do this: assume account number is invalid; then iterate
						//through the accountNumbers array, each time comparing userAccountNumber to the
						//current element of accountNumbers to see if there is a match
						//use the flag variable accountNumberIsValid to keep track of this
						accountNumberIsValid = false;
						
						//we will loop until the user enters a valid account number
						do
						{
							
						
							for (int i = 0; i < accountNumbers.length; i++)
							{
								if (accountNumbers[i].equals(userAccountNumber))
								{
									accountNumberIsValid = true;

								}
							}
							
							//TO-DO: complete the if-else statement
							if (accountNumberIsValid)
							{
								//print message to user
								System.out.println("Your order is complete! Thank you!");
								System.exit(0);
							}
							if (!accountNumberIsValid)
							{
								//prompt user again; store input in variable userAccountNumber
								System.out.println("Please try again: ");
								userAccountNumber = keyboard.nextLine();

							}
						} while (!accountNumberIsValid);
						
						
						break;
					
					case 6: //exit
						System.out.println("\nThanks for stopping by! Goodbye!");
						break;
						
					default:
						System.out.println("Invalid selection. Please try again");
			}
		
		
		} while (menuChoice != 6);	//end main program loop
	}
	
	public static void displayMenuOptions()
	{
	
	System.out.println("Menu options:\n 1. View item selection\n 2. View shopping cart\n" +
	" 3. Add item to cart\n 4. Remove item from cart\n 5. Checkout\n 6. Exit\n\n");
	
	}
	
	
	
}

