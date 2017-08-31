package spring.assignment;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
 * @author Sudhakar
 */
		

public class Customer {

	private String customerName ;
	private int totalTimeToEat;
	private int sumTimeToEatAllItem = 0;

	private Boolean hasCrossedTime = Boolean.FALSE;

	private static final String FILENAME = "data.txt";

	private Menu menu = null;

	public Customer(String customerName, int totalTimeToEat, Menu menu) {
		this.customerName = customerName;
		this.totalTimeToEat = totalTimeToEat * 60;
		this.menu = menu;
		numberOfItemsToEat();
	}

 
	private int numberOfItemsToEat() {

		readInputFileAndScan();
		printAllSatisfactoryLimit();
		return 1;
	}

	private void printAllSatisfactoryLimit() {
		FoodItems[] finalItems = menu.getItemList();

		findMaxSatisfactoryLevel(finalItems);

	}

	/**
	 * Sort the food Items with the help of customized comparator and Identifies the max satisfactory
	 
	 * @param itemList
	 */
	private void findMaxSatisfactoryLevel(FoodItems[] itemList) {
		Arrays.sort(itemList, new CustomComparator());
		
		for (int j = 0; j < itemList.length; j++) {
			System.out.print(itemList[j].getLimit() + " ");
		}
		
		System.out.println(customerName + " had " + " max satisfaction " + itemList[0].getLimit()
				+ " for the item '" + itemList[0].getName() + "' in Menu ");

	}

	/**
	 *read the input data 
	 */
	private void readInputFileAndScan() {
		int itemCount = 0;
		try {
			Scanner scanreadar = new Scanner(new File(FILENAME));

			String line;
			while ((line = scanreadar.next()) != null) {

				if (!hasCrossedTime) {
					tokenizeLine(line, itemCount);
					itemCount++;

				} else {
					break;
				}
			}
			menu.setItemList(Arrays.copyOf(menu.getItemList(), itemCount - 1));

		} catch (IOException e) {
			System.err.println("IOException while reading input data.. " + e.getStackTrace());
		}
	}

	/**
	 * @param line
	 * @param itemCount
	 */
	private void tokenizeLine(String line, int itemCount) {

		itemCount = itemCount + 1;
		int timeTakenPerDish = 0;
		StringTokenizer tokens = new StringTokenizer(line, " ");

		menu.getItemList()[itemCount].setLimit(Integer.parseInt(tokens.nextToken()));
		if (tokens.hasMoreElements()) {
			timeTakenPerDish = Integer.parseInt(tokens.nextToken());
			menu.getItemList()[itemCount].setTimeTaken(timeTakenPerDish);
		}
		sumTimeToEatAllItem = sumTimeToEatAllItem + timeTakenPerDish;
		if (sumTimeToEatAllItem > totalTimeToEat) {
			hasCrossedTime = Boolean.TRUE;
			return;
		}
		System.out.println(customerName + " had " + menu.getItemList()[itemCount].getName() + " for about "
				+ menu.getItemList()[itemCount].getTimeTaken() + " secs " + " and has got satisfactory level of "
				+ menu.getItemList()[itemCount].getLimit());

	}

}
