package spring.assignment;

import java.util.Comparator;
/*
 *  @author Sudhakar
 *  this is a custom comparator for sorting the food items
 */

public class CustomComparator implements Comparator<FoodItems> {

	@Override
	public int compare(FoodItems o1, FoodItems o2) {
		// Sort in descending order.
		return o2.getLimit() - o1.getLimit();
	}

}
