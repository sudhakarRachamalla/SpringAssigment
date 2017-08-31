package spring.assignment;

/*Gordon Ramsey, a very smart guy, likes eating food. Now, Gordon is at a restaurant and he has many different types of food to choose from. Gordon gets x amount of satisfaction and requires y amount of time to eat an item from the menu. Given t minutes, write a java program that reads the text file and ﬁnds out the maximum satisfaction that Gordon can get from eating at the restaurant. You will be given a text file with the following format:
	 
[t][Number of items on menu]
[amount of satisfaction from eating dish 1][time taken for dish 1]
[amount of satisfaction from dish 2][time taken for dish 2]
*@author sudhakar
*/

public class MainClass {

	private static Menu menu;

	private static Customer customer;
	
	

	/**
	 * pass the input from arguments.  Customer Name  Time
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		int time = 0;
		try {
			System.out.println("Customer name .. " + args[0]);
			System.out.println("Time in mins to have dishes .. " + args[1] + " mins");
			time = Integer.parseInt(args[1]);
		} catch (NumberFormatException nfe) {
			System.err.println("valid time means pass the integers .." + nfe.getMessage());
		} catch (ArrayIndexOutOfBoundsException oe) {
			System.err.println("input argsment are missing. customer name and time" + oe.getMessage());
		}

		menu = new Menu();
		customer = new Customer(args[1], time, menu);
	}

}
