package tamagotchi;

/**
 * Class that represents a variety of food types that can be fed to a virtual
 * pet
 * 
 * @author Isla Purkey
 */
public class Food {
	// Hard coded values for each food type
	String[] foodType = { "Pet Food", "Organic Pet Food", "Treat" };
	String[] flavorText = { "Standard pet food", "Pet food made without petsticides", "A special treat for your pet" };
	int[] foodHungerDecrease = { 10, 9, 5 };
	int foodCount = foodType.length;
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
	 * Gets the current hunger reduction for the passed food index
	 * 
	 * @param selectedFood The food index to be evaluated
	 * @return The hunger decrease of that food. Returns -1 if the food input is
	 *         invalid
	 */
	public int getHungerDecrease(int selectedFood) {
		if (selectedFood > foodHungerDecrease.length - 1) {
			return -1;
		} else if (selectedFood < 0) {
			return -1;
		} else {
			return foodHungerDecrease[selectedFood];
		}
	}

	/**
	 * Selects a food that can be fed to the pet.
	 * 
	 * @param selection The index of the food that will be selected
	 */
	public void selectFood(int selection) {
		selectedFood = selection;
	}
}
