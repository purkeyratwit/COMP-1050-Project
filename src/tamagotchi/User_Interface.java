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
	public static final String FORMAT_ERR_MSG = "Non-integer value(s) provided!";

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

	/**
	 * Updates the current console output to represent the current dirtiness class
	 * 
	 * @param dirtinessInput The current state of the dirtiness class
	 */
	public void updateScreen(Dirtiness dirtinessInput) {
		if (dirtinessInput.cleaningStatus == -1) {
			System.out.printf("Select a cleaning method for %s", petName);
			printOptions(dirtinessInput.cleaningType);
		}
	}

	/**
	 * Updates the current console output to represent the current Trivia_Game class
	 * 
	 * @param boredomInput The current state of the boredom class
	 */
	public void updateScreen(Trivia_Game TriviaInput) {
		if (TriviaInput.gameStatus == 1) {
			System.out.printf("It is %s's turn! %s is typing their answer...", petName, petName);
		} else if (TriviaInput.gameStatus == 2) {
			System.out.printf("It is your turn! Type your answer...");
		} else if (TriviaInput.gameStatus == 3) {
			System.out.println("You won!");
		} else if (TriviaInput.gameStatus == 4) {
			System.out.printf("%s won!", petName);
		} else if (TriviaInput.gameStatus == 5) {
			System.out.println("No winner!");
		} else if (TriviaInput.gameStatus == 6) {
			System.out.println("What would you like to do now?");
			printOptions(new String[]{ "Start a new game", "Return to the main menu" });
		}

	}

	/**
	 * Updates the current console output to represent the current Tic_Tac_Toe class
	 * 
	 * @param boredomInput The current state of the boredom class
	 */
	public void updateScreen(Tic_Tac_Toe_Game tttInput) {
		if (tttInput.gameStatus == 1) {
			System.out.printf("Enter a X coordnate from the valid list: ");
		} else if (tttInput.gameStatus == 2) {
			System.out.printf("Enter a Y coordnate from the valid list: ");
		} else if (tttInput.gameStatus == 3) {
			System.out.printf("  1 2 3%n");
			System.out.printf(" ┌─┬─┬─┐%n");
			for (int i = 0; i < 3; i++) {
				System.out.printf("%d│", i + 1);
				for (int j = 0; j < 3; j++) {
					System.out.printf("%s│", tttInput.gameBoard[i][j]);
				}
				if (i != 2) {
					System.out.printf("%n ├─┼─┼─┤%n");
				} else {
					System.out.printf("%n └─┴─┴─┘%n");
				}
			}
		} else if (tttInput.gameStatus == 4) {
			System.out.printf("%nYou won!%n");
		} else if (tttInput.gameStatus == 5) {
			System.out.printf("%n%s won!%n", petName);
		} else if (tttInput.gameStatus == 6) {
			System.out.printf("%nNo winner!%n");
		} else if (tttInput.gameStatus == 7) {
			System.out.printf("What would you like to do now?");
			printOptions(new String[] { "Start a new game", "Return to the main menu" });
		}
	}

	/**
	 * Updates the current console output to represent the current pet's health
	 * 
	 * @param stats true if the pet is healthy, false otherwise
	 */
	public void updateScreen(Pet pet) {
		clearScreen();
		pet.updateStats();
		if (pet.getHealth() >= 10) {
			System.out.printf("%s's current stats (Lower = Better):%n", pet.getName());
			// Prints the pets current statistics
			System.out.printf("Hunger: %d%n", 100 - pet.getHunger());
			System.out.printf("Boredom: %d%n", 100 - pet.getBoredom());
			System.out.printf("Dirtiness: %d%n", 100 - pet.getDirtiness());
			System.out.printf("Health: %.0f%s%n", pet.getHealth(), "%");

			System.out.printf("%n");
			System.out.printf("Enter \"1\" to return to the main menu!%n");
		} else {
			formattedString = "Your pet has passed away! Would you like to try again? Your pet will be reset to how it was on creation.";
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

		printOptions(new String[] { "Feed your pet", "Bathe your pet", "Play with your pet",
				"Check how your pet is doing", "Exit the game" });
	}

	/**
	 * Clears the console output to allow for new text to be printed
	 */
	public void clearScreen() {
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