package tamagotchi;

/**
 * Class to handle user input and that includes a main method
 * 
 * @author Isla Purkey
 */

import java.util.Scanner;
import java.lang.NumberFormatException;
import java.util.InputMismatchException;

public class Tamogatchi_game {

	/**
	 * Simple method to handle creating a Pet object upon the program's startup
	 * 
	 * @return Pet object created
	 */
	public static Pet createPet(Scanner input) {
		System.out.printf("Hello! Please name your pet: ");
		String petName = input.next();

		System.out.printf("Would you like to setup any initial starting conditions?");
		User_Interface.printOptions(new String[] { "Yes", "No" });

		while (true) {
			String userResponse = input.next();

			// Handles if the user input for an option isn't a number
			try {
				if (Integer.valueOf(userResponse) == 1) {

					while (true) {
						// Handles if the provided values aren't numbers
						try {
							System.out.printf(
									"Enter values for the pets food, boredom, and dirtiness statistic (0-100): ");
							int[] values = new int[3];
							for (int i = 0; i < 3; i++) {
								int currentInput = input.nextInt();

								if (currentInput > 100) {
									currentInput = 100;
								} else if (currentInput < 0) {
									currentInput = 0;
								}

								values[i] = currentInput;
							}

							return new Pet(petName, values[0], values[1], values[2]);
						} catch (InputMismatchException ex) {
							System.out.printf("Non-integer value(s) provided!%n");
							// Resets scanner tokens
							input.skip(".*");
						}
					}

				} else if (Integer.valueOf(userResponse) == 2) {
					return new Pet(petName);

				} else {
					System.out.printf("%s: ", User_Interface.OPTION_ERR_MSG);
				}

			} catch (NumberFormatException ex) {
				System.out.printf("%s: ", User_Interface.OPTION_ERR_MSG);
			}
		}
	}
	
	public static int getChoice(Scanner input, int max) {
		while (true)
			try {
				int userResponse = input.nextInt();
				if (userResponse > max) {
					System.out.printf("%s: ", User_Interface.OPTION_ERR_MSG);
				} else if (userResponse < 1) {
					System.out.printf("%s: ", User_Interface.OPTION_ERR_MSG);
				} else {
					return userResponse;
				}
			} catch (NumberFormatException ex) {
				System.out.printf("%s: ", User_Interface.OPTION_ERR_MSG);
			}
	}

	/**
	 * Main method
	 * 
	 * @param args Command line arguments, ignore
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		User_Interface ui;
		Food food = new Food();
		Dirtiness dirty = new Dirtiness();
		Boredom bored = new Boredom();
		int userResponse;

		Pet pet = createPet(input);

		ui = new User_Interface(pet);

		while (true) {
			ui.updateScreen();
			userResponse = getChoice(input, 5);
			if (userResponse == 1) {
				food.foodStatus = 1;
				ui.updateScreen(food);
				userResponse = getChoice(input, 4);
				// Handle getting user response
			} else if (userResponse == 2) {
				// TODO bathing the pet
				System.out.printf("2");
			} else if (userResponse == 3) {
				// TODO games
				System.out.printf("3");
			} else if (userResponse == 4) {
				// TODO Checking pet stats
				System.out.printf("4");
			} else if (userResponse == 5) {
				System.exit(0);
			}
		}
	}

}
