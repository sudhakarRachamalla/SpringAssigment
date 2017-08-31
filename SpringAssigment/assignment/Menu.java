package spring.assignment;

/*
 * @author Sudhakar
 */

public class Menu {

	public FoodItems[] items = new FoodItems[101];

	public Menu() {
		populateItems();
	}

	public void setItemList(FoodItems[] items) {
		this.items = items;
	}

	public FoodItems[] getItemList() {
		return items;
	}

	public void populateItems() {
		FoodItems item;

		for (int i = 0; i < 100; i++) {
			item = new FoodItems(i, "Dish-" + i);
			items[i] = item;
		}

	}

}
