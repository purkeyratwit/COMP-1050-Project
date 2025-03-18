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
		String petName = input.nextLine();

		System.out.printf("%nWould you like to setup any initial starting conditions?");
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
									"%nEnter values for the pets food, boredom, and dirtiness statistic (0-100): ");
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
							System.out.printf("%s: ", User_Interface.FORMAT_ERR_MSG);
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

	/**
	 * Simple method to get a numeric choice from the user
	 * 
	 * @param input Scanner which contains user input
	 * @param max   Highest number option choice
	 * @return The user provided number
	 */
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
			} catch (InputMismatchException ex) {
				input.nextLine(); // Clears the invalid token
				System.out.printf("%s: ", User_Interface.FORMAT_ERR_MSG);
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
		int userResponse, userFoodIndex;

		Pet pet = createPet(input);
		Pet defaultPet = pet;

		ui = new User_Interface(pet);

		while (true) {
			ui.updateScreen();
			userResponse = getChoice(input, 5);
			ui.clearScreen();
			if (userResponse == 1) {
				/*
				 * Food option
				 */
				food.foodStatus = 1;
				ui.updateScreen(food);
				userFoodIndex = getChoice(input, food.foodCount);
				ui.confirm();
				userResponse = getChoice(input, 2);
				if (userResponse == 1) {
					food.selectFood(userFoodIndex - 1);
					pet.setHunger(pet.getHunger() + food.getHungerDecrease(food.selectedFood));
				}
			} else if (userResponse == 2) {
				// TODO bathing the pet
				System.out.printf("2");
			} else if (userResponse == 3) {
				/*
				 * Game option
				 */
				System.out.printf("What would you like to do? ");
				User_Interface.printOptions(bored.gameMenuOptions);
				userResponse = getChoice(input, 3);
				if (userResponse == 1) {
					/*
					 * Tic Tac Toe Game Option
					 */
					bored.setGame(1);
					bored.startGame();
					while (bored.gameOngoing) {
						ui.clearScreen();
						Tic_Tac_Toe_Game tttGame = new Tic_Tac_Toe_Game();

						System.out.printf(
								"Pick a starting position on the board!%n(1,1) Represents the top left corner and (3,3) represents the bottom right corner");
						User_Interface.printOptions(new String[] { "X options: 1, 2, 3", "Y options: 1, 2, 3" });

						tttGame.gameStatus = 1;
						for (int i = 0; i < 4; i++) { // TODO modify this loop so the game can be terminated early if a
														// winner is found before 8 turns have been played. use
														// gameOngoing or gameStatus to do that probably
							// Gets user position choice
							int x, y;
							do {
								ui.updateScreen(tttGame);
								x = getChoice(input, 3);
								ui.updateScreen(tttGame);
								y = getChoice(input, 3);

								if (!tttGame.validOption(x, y)) {
									System.out.printf("%nPlease enter a set of valid coordnates!%n");
									tttGame.gameStatus = 1;
								}

							} while (!tttGame.validOption(x, y));

							tttGame.gameBoard[y - 1][x - 1] = "X";

							// TODO Check for a winner using tttGame.checkWinner(); If there is a winner
							// print the game board and some flavor text.

							int[] petChoice = tttGame.petChoice(tttGame.gameBoard);
							tttGame.gameBoard[petChoice[0]][petChoice[1]] = "O";

							// TODO Check for a winner using tttGame.checkWinner(); If there is a winner
							// print the game board and some flavor text.

							// Prints game board
							ui.clearScreen();
							ui.updateScreen(tttGame);
						}

						// TODO At this point, 8/9 spots on the board have been filled, so the last one
						// needs to be filled in with the player's symbol (X) and the potential winner
						// needs to be determined

						// TODO Afterwards pet stats need to be incremented

					}
				} else if (userResponse == 2) {
					/*
					 * Trivia game handling
					 */

				}
			} else if (userResponse == 4) {
				/*
				 * Statistics option
				 */
				ui.updateScreen(pet);
				if (pet.getHealth() >= 10) {
					getChoice(input, 1);
				} else {
					userResponse = getChoice(input, 2);
					if (userResponse == 1) {
						// TODO Don't use this method, set values manually
						pet = defaultPet;
					} else {
						System.exit(0);
					}
				}
			} else if (userResponse == 5) {
				/*
				 * Exit option
				 */
				System.exit(0);
			}
		}
	}

}
