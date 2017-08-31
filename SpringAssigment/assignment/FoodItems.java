package spring.assignment;

/*
 * @author Sudhakar
 */

public class FoodItems {
	
	private int id;

	private String name;

	private int limit;

	private int timeTaken;

	public FoodItems(int id, String name) {
		this.name = name;
		this.id = id;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(int timeTaken) {
		this.timeTaken = timeTaken;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}


}
