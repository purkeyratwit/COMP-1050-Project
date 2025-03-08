package tamagotchi;

/**
 * Class that represents a variety of food types that can be fed to a virtual pet
 * 
 * @author Isla Purkey
 */
public class Food {
	// Hard coded values for each food type
	String[] foodType = { "Pet Food", "Organic Pet Food", "Medication", "Treat" };
	String[] foodEffects = { "None", "None", "Healing", "BoredomDecrease" };
	String[] flavorText = { "Standard pet food", "Pet food made without petsticides",
			"Medicine to help with pet health", "A special treat for your pet" };
	int[] foodHungerDecrease = { 10, 8, 0, 2 };

	int foodStatus = 0;
	int selectedFood = 0;

	/*
	 * Default Constructor
	 */
	public Food() {
		selectedFood = 0;
	}

	/**
	 * Provides the current valid food(s) list
	 * 
	 * @return The current food list
	 */
	public String[] getFoodList() {
		return foodType;
	}

	/**
	 * Gets the current hunger reduction for the passed food
	 * 
	 * @param selectedFood The food to be evaluated
	 * @return The hunger decrease of that food. Returns -1 if the food input is
	 *         invalid
	 */
	public int getHungerDecrease(String selectedFood) {
		// TODO
		return 0;
	}

	/**
	 * Selects a food that can be fed to the pet.
	 * 
	 * @param selection The index of the food that will be selected
	 */
	public void selectFood(int selection) {
		// TODO
	}
}
