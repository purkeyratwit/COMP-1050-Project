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

	/**
	 * Constructor, takes the current pet as input and creates a base for future
	 * method calls to be based off of
	 * 
	 * @param pet The current pet
	 */
	public User_Interface(Pet pet) {
		petName = pet.getName();
	}

	/**
	 * Updates the current console output to represent the current food class
	 * 
	 * @param foodInput The current state of the food class
	 */
	public void updateScreen(Food foodInput) {
		// TODO
	}

	/**
	 * Updates the current console output to represent the current dirtiness class
	 * 
	 * @param dirtinessInput The current state of the dirtiness class
	 */
	public void updateScreen(Dirtiness dirtinessInput) {
		// TODO
	}

	/**
	 * Updates the current console output to represent the current boredom class
	 * 
	 * @param boredomInput The current state of the boredom class
	 */
	public void updateScreen(Boredom boredomInput, int questionNumber) {
		// TODO
	}

	/**
	 * Updates the current console output to represent the current pet's health
	 * 
	 * @param stats true if the pet is healthy, false otherwise
	 */
	public void updateScreen(Pet pet) {
		clearScreen();
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
			formattedString = "Your pet has passed away! Would you like to try again?";
			System.out.printf("%s", formattedString);

			printOptions(new String[] { "Yes", "No" });
		}
	}

	/**
	 * Updates the current console output to represent the main menu
	 */
	public void updateScreen() {
		clearScreen();
		System.out.printf("Main menu for %s: %nPlease select an option!", petName);
		
		printOptions(new String[] {"Feed your pet", "Bathe your pet", "Play with your pet", "Check how your pet is doing", "Exit the game"});
	}

	/**
	 * Clears the console output to allow for new text to be printed
	 */
	public static void clearScreen() {
		for (int i = 0; i < 30; i++) {
			System.out.printf("%n");
		}
	}

	/**
	 * Prints the current options available to the user
	 * 
	 * @param optionsList Array of available options
	 */
	public static void printOptions(String[] optionsList) {
		if(optionsList.length > 0) {
			System.out.println();
			System.out.println();
		}
		for (int i = 0; i < optionsList.length; i++) {
			System.out.printf("%d. %s%n", i+1, optionsList[i]);
		}
	}
}