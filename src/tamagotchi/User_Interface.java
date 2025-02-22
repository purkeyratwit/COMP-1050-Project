package tamagotchi;

/**
 * Class that prints information to the console based on the user's input and/or
 * current state of the program
 * 
 * @author Isla Purkey
 */
public class User_Interface {

	public static String formattedString = "";

	/**
	 * Constructor, takes the current pet as input and creates a base for future
	 * method calls to be based off of
	 * 
	 * @param pet The current pet
	 */
	public User_Interface(Pet pet) {
		// TODO
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
	public static void updateScreen(Pet pet) {
		if (pet.getHealth() >= 10) {
			System.out.printf("%s's current stats:%n", pet.getName());
			// Prints the pets current statistics
			System.out.printf("Hunger: %d%n", pet.getHunger());
			System.out.printf("Boredom: %d%n", pet.getBoredom());
			System.out.printf("Dirtiness: %d%n", pet.getDirtiness());
			System.out.printf("Health: %.0f%n", pet.getHealth());
			
			System.out.printf("%n");
			System.out.printf("Enter \"1\" to return to the main menu!%n");
			System.out.printf("%n%n%n"); // Temporary
		} else {
			formattedString = "Your pet has passed away! Would you like to try again?";
			System.out.printf("%s", formattedString);

			printOptions(new String[] { "1. Yes", "2. No" });
		}
	}

	/**
	 * Updates the current console output to represent the main menu
	 */
	public static void updateScreen() {
		// TODO
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
		// TODO
	}

	/**
	 * !!!TEMPORARY!!!
	 * 
	 * This method is used for testing different User_Interface methods until a
	 * proper input handling method is developed
	 * 
	 * @param args Command line arguments, ignore
	 */
	public static void main(String args[]) {
		Pet test1 = new Pet("Dummy", 50, 40, 20);
		updateScreen(test1);

		Pet test2 = new Pet("Even more dummy");
		updateScreen(test2);
		
		Pet test3 = new Pet();
		updateScreen(test3);
	}
}
