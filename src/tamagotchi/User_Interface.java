package tamagotchi;

/**
 * Class that prints information to the console based on the user's input and/or
 * current state of the program
 * 
 * @author Isla Purkey
 */
public class User_Interface {

	public static String formattedString = "";
	public static String petName;
	public static final String OPTION_ERR_MSG = "Please enter a number in the valid range";

	public User_Interface(Pet pet) {
		petName = pet.getName();
	}

	public void updateScreen(Food foodInput) {
		System.out.printf("%n");
		if (foodInput.foodStatus == 1) {
			String[] foodList = foodInput.getFoodList();
			String[] foodFlavorText = foodInput.flavorText;

			System.out.printf("Select a food to feed %s", petName);

			// Prints options with flavor text
			System.out.println();
			System.out.println();
			for (int i = 0; i < foodList.length; i++) {
				System.out.printf("%d. %s: %s%n", i + 1, foodList[i], foodFlavorText[i]);
			}
		}
	}

	public void updateScreen(Dirtiness dirtinessInput) {
		// TODO
	}

	public void updateScreen(Boredom boredomInput, int questionNumber) {
		// TODO
	}

	public void updateScreen(Pet pet) {
		clearScreen();
		pet.updateStats();
		if (pet.getHealth() >= 10) {
			System.out.printf("%s's current stats:%n", pet.getName());
			// Prints the pets current statistics
			System.out.printf("Hunger: %d%n", pet.getHunger());
			System.out.printf("Boredom: %d%n", pet.getBoredom());
			System.out.printf("Dirtiness: %d%n", pet.getDirtiness());
			System.out.printf("Health: %.0f%n", pet.getHealth());

			System.out.printf("%n");
			System.out.printf("Enter \"1\" to return to the main menu!%n");
		} else {
			formattedString = "Your pet has passed away! Would you like to try again? Your pet will be reset to how it was on creation.";
			System.out.printf("%s", formattedString);

			printOptions(new String[] { "Yes", "No" });
		}
	}

	public void updateScreen() {
		clearScreen();
		System.out.printf("Main menu for %s: %nPlease select an option!", petName);

		printOptions(new String[] { "Feed your pet", "Bathe your pet", "Play with your pet",
				"Check how your pet is doing", "Exit the game" });
	}

	public void clearScreen() {
		for (int i = 0; i < 30; i++) {
			System.out.printf("%n");
		}
	}

	public static void printOptions(String[] optionsList) {
		if (optionsList.length > 0) {
			System.out.println();
			System.out.println();
		}
		for (int i = 0; i < optionsList.length; i++) {
			System.out.printf("%d. %s%n", i + 1, optionsList[i]);
		}
	}

	public void confirm() {
		System.out.printf("%nAre you sure?");
		printOptions(new String[] { "Yes", "No" });
	}
}