package tamagotchi;

public class Food {
	// Hard coded values for each food type
	String[] foodType = { "Pet Food", "Organic Pet Food", "Treat", "Chocolate" };
	String[] flavorText = { "Standard pet food", "Pet food made without petsticides", "A special treat for your pet",
			"Unhealthy chocolate for your pet" };
	int[] foodHungerDecrease = { 10, 9, 5, -10 };
	int foodCount = foodType.length;
	int foodStatus = 0;
	int selectedFood = 0;

	public Food() {
		selectedFood = 0;
	}

	public String[] getFoodList() {
		return foodType;
	}
	
	public int getHungerDecrease(int selectedFood) {
		if (selectedFood > foodHungerDecrease.length - 1) {
			return -1;
		} else if (selectedFood < 0) {
			return -1;
		} else {
			return foodHungerDecrease[selectedFood];
		}
	}

	public void selectFood(int selection) {
		selectedFood = selection;
	}
}
