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
	 * Simple method to handle creating a Pet object upon the program's startup.
	 * 
	 * @return Pet object created
	 */
	public static Pet createPet(Scanner input) {
		System.out.printf("Hello! Do you have a save file to load from?");
		User_Interface.printOptions(new String[] { "Yes", "No" });
		int intUserResponse = getChoice(input, 2);

		// Clears new line character
		input.nextLine();

		if (intUserResponse == 1) {
			System.out.printf("Enter a .txt file path: ");
			String filePath = input.nextLine();
			Pet tempPet = Pet.readFromFile(filePath, input);

			if (!(tempPet.name.equals("N/A"))) {
				return tempPet;
			}
			// Creates User_Interface object to call clearScreen();
			User_Interface ui = new User_Interface(tempPet);
			ui.clearScreen();
		}
		System.out.printf("%n");

		System.out.printf("Please name your pet: ");
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
	 * Method to perform a Tic Tac Toe game
	 * 
	 * @param ui    The User_Interface variable instantiated with the pets name
	 * @param input Scanner object
	 * @return The boredom decrease value
	 */
	public static int TTTGame(User_Interface ui, Scanner input) {
		int userResponse = 1;
		Tic_Tac_Toe_Game tttGame = new Tic_Tac_Toe_Game();
		int boredomIncrease = 0;

		while (true) {
			// Starts a new game
			ui.clearScreen();
			tttGame.resetGame();

			// Prints new game flavor text
			System.out.printf("Pick a starting position on the board!%n");
			System.out.printf("(1,1) Represents the top left corner and (3,3) represents the bottom right corner");
			User_Interface.printOptions(new String[] { "X options: 1, 2, 3", "Y options: 1, 2, 3" });

			// Handles the first 8 moves (4 for the user, 4 for the pet). Will abort early
			// if a winner is determined before the loop completes
			int x, y;
			for (int i = 0; i < 4; i++) {
				// Gets user position choice
				do {
					tttGame.gameStatus = 1;

					ui.updateScreen(tttGame);
					x = getChoice(input, 3);
					tttGame.gameStatus = 2;

					ui.updateScreen(tttGame);
					y = getChoice(input, 3);
					tttGame.gameStatus = 3;

					if (!tttGame.validOption(x, y)) {
						System.out.printf("%nPlease enter a set of valid coordnates!%n");
					}
				} while (!tttGame.validOption(x, y));

				// Applies the user's move
				tttGame.gameBoard[y - 1][x - 1] = "X";

				// If X wins, finish the game
				if (tttGame.checkWinner().equals("X")) {
					// Prints the game board
					ui.clearScreen();
					tttGame.gameStatus = 3;
					ui.updateScreen(tttGame);

					// Prints the player win flavor text and ends the game
					tttGame.gameStatus = 4;
					ui.updateScreen(tttGame);
					tttGame.gameStatus = 7;

					// Adds to return value
					boredomIncrease += Boredom.getBoredomDecrease(1);

					// Aborts the for loop
					break;
				}

				// Determines the pet's choice
				int[] petChoice = tttGame.petChoice(tttGame.gameBoard);

				// Applies the pet's choice
				tttGame.gameBoard[petChoice[0]][petChoice[1]] = "O";

				// If O wins, finish the game
				if (tttGame.checkWinner().equals("O")) {
					// Prints the game board
					ui.clearScreen();
					tttGame.gameStatus = 3;
					ui.updateScreen(tttGame);

					// Prints the pet win flavor text and ends the game
					tttGame.gameStatus = 5;
					ui.updateScreen(tttGame);
					tttGame.gameStatus = 7;

					// Adds to return value
					boredomIncrease += (Boredom.getBoredomDecrease(1) / 2);

					// Aborts the for loop
					break;
				}

				// Prints the game board
				ui.clearScreen();
				tttGame.gameStatus = 3;
				ui.updateScreen(tttGame);
			}

			// Check if the game has ended early
			if (tttGame.gameStatus == 7) {
				// Checks if the user wishes to continue playing, and if they do not then
				// returns to the main menu
				ui.updateScreen(tttGame);
				userResponse = getChoice(input, 2);
				if (userResponse == 2) {
					break;
				}
			} else {
				// Final move done automatically

				// Gets the x & y values for the last valid spot on the board
				char value = tttGame.getValidOptions()[0].charAt(0);
				x = Integer.valueOf(value) - 49;

				value = tttGame.getValidOptions()[0].charAt(3);
				y = Integer.valueOf(value) - 49;

				// Applies the final move to the game board
				tttGame.gameBoard[x][y] = "X";

				// Prints the game board
				ui.clearScreen();
				tttGame.gameStatus = 3;
				ui.updateScreen(tttGame);

				// Checks if the final move caused the player to win
				if (tttGame.checkWinner().equals("X")) {
					// Prints the player win flavor text and ends the game
					tttGame.gameStatus = 4;
					ui.updateScreen(tttGame);

					// Adds to return value
					boredomIncrease += Boredom.getBoredomDecrease(1);
				} else {
					// Prints the no winner flavor text and ends the game
					tttGame.gameStatus = 6;
					ui.updateScreen(tttGame);

					// Adds to return value
					boredomIncrease += Math.round(Boredom.getBoredomDecrease(1) / 1.5);
				}

				// Checks if the user wishes to continue playing, and if they do not then
				// returns to the main menu
				tttGame.gameStatus = 7;
				ui.updateScreen(tttGame);
				userResponse = getChoice(input, 2);
				if (userResponse == 2) {
					break;
				}
			}
		}
		return boredomIncrease;
	}
	public static int triviaGame(User_Interface ui, Scanner input) {
		int userResponse = 1;
		int boredomIncrease = 0;
		int petScore = 0;
		int playerScore = 0; 
		// Starts a new game with user-provided questions
		while(true) {			
			System.out.println("Would you like to use your own trivia questions? (Y/N)");
		
			String choice = input.nextLine(); 
			if (choice == "Y") {
				System.out.println("Enter the file name: ");
				String fileName = input.nextLine();			
				Trivia_Game triviaGame = new Trivia_Game(fileName);
				ui.clearScreen();
				triviaGame.resetGame();
			// Prints new game flavor text
			System.out.println("This game will have 10 questions.");
			System.out.println("The player who answers the most questions correctly wins!"); 

			for (int i = 0; i < 10; i++) {
				// Prints question and notes position in array 
				int questionAndAnswerIndex = triviaGame.pickQuestion(triviaGame.questionArray);
				System.out.printf(triviaGame.questionArray[questionAndAnswerIndex]);
				//Pet's turn
				triviaGame.gameStatus = 1;
				ui.updateScreen(triviaGame);
				String answer = triviaGame.answerArray[triviaGame.pickQuestion(triviaGame.answerArray)];
				if (triviaGame.checkAnswer(answer, petScore)) {
					petScore++;
				}
				//Player's turn
				triviaGame.gameStatus = 2;
				answer = input.nextLine(); 
				ui.updateScreen(triviaGame);
				if (triviaGame.checkAnswer(answer, questionAndAnswerIndex)) {
					playerScore++;
				}
			//Checks score at the end of the game. 
			} if (playerScore > petScore) {
				triviaGame.gameStatus = 3;
				ui.updateScreen(triviaGame);
				//Adds to return value
				boredomIncrease += Boredom.getBoredomDecrease(1);
			} if (petScore > playerScore) {
				triviaGame.gameStatus = 4;
				ui.updateScreen(triviaGame);
				boredomIncrease += (Boredom.getBoredomDecrease(1) / 2);
				
			} else if (playerScore == petScore) {
				triviaGame.gameStatus = 5;
				ui.updateScreen(triviaGame);
				boredomIncrease += Math.round(Boredom.getBoredomDecrease(1) / 1.5);
			}	
				//Checks if user would like to return to menu or start a new game
				triviaGame.gameStatus = 6;
				ui.updateScreen(triviaGame);
				userResponse = getChoice(input, 2);
				if(userResponse == 2) {
					break;
				}
				
		} else if(choice == "N") {
			// Starts a new game with default questions
			Trivia_Game triviaGame = new Trivia_Game();
			ui.clearScreen();
			triviaGame.resetGame();
			//Prints new game flavor text
			System.out.println("This game will have 10 questions.");
			System.out.println("The player who answers the most questions correctly wins!"); 

			for (int i = 0; i < 10; i++) {
				// Prints question and notes position in array 
					int questionAndAnswerIndex = triviaGame.pickQuestion(triviaGame.questionArray);
					System.out.printf(triviaGame.questionArray[questionAndAnswerIndex]);
				//Pet's turn
					triviaGame.gameStatus = 1;
					ui.updateScreen(triviaGame);
					String answer = triviaGame.answerArray[triviaGame.pickQuestion(triviaGame.answerArray)];
					if (triviaGame.checkAnswer(answer, petScore)) {
						petScore++;
					}
				
					//Player's turn
					triviaGame.gameStatus = 2;
					answer = input.nextLine(); 
					ui.updateScreen(triviaGame);
					if (triviaGame.checkAnswer(answer, questionAndAnswerIndex)) {
						playerScore++;
					}
					//Checks score at the end of the game. 
			} if (playerScore > petScore) {
				triviaGame.gameStatus = 3;
				ui.updateScreen(triviaGame);
				//Adds to return value
				boredomIncrease += Boredom.getBoredomDecrease(1);
			} if (petScore > playerScore) {
				triviaGame.gameStatus = 4;
				ui.updateScreen(triviaGame);
				boredomIncrease += (Boredom.getBoredomDecrease(1) / 2);
				
			} else if (playerScore == petScore) {
				triviaGame.gameStatus = 5;
				ui.updateScreen(triviaGame);
				boredomIncrease += Math.round(Boredom.getBoredomDecrease(1) / 1.5);
			}	
				//Checks if user would like to return to menu or start a new game
				triviaGame.gameStatus = 6;
				ui.updateScreen(triviaGame);
				userResponse = getChoice(input, 2);
				if(userResponse == 2) {
					break;
				}
			}
		} return boredomIncrease;
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
		Boredom bored = new Boredom();
		Dirtiness dirty = new Dirtiness();
		int userResponse, userFoodIndex, userDirtyIndex;

		Pet pet = createPet(input);
		Pet initialPet = new Pet(pet.getName(), pet.getHunger(), pet.getBoredom(), pet.getDirtiness());

		ui = new User_Interface(pet);

		while (true) {
			ui.updateScreen();
			userResponse = getChoice(input, 5);
			ui.clearScreen();

			/*
			 * Note: the second option is for dirtiness and the third is for boredom. This
			 * is different from how it is ordered elsewhere in the program (with the second
			 * being boredom and third being dirtiness).
			 */
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
				/*
				 * Dirtiness option
				 */
				
				// Prints cleaning methods
				dirty.cleaningStatus = -1;
				ui.updateScreen(dirty);

				// Gets the type of clean the user would like to select
				userDirtyIndex = getChoice(input, dirty.cleaningType.length);
				
				// Confirms their selection
				ui.confirm();
				userResponse = getChoice(input, 2);
				
				// If confirmed, applies the statistic change to the pet
				if (userResponse == 1) {
					pet.setDirtiness(pet.getDirtiness() + dirty.cleaningDirtinessDecrease[userDirtyIndex - 1]);
				}
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
					pet.setBoredom(pet.getBoredom() + TTTGame(ui, input));
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
						pet = new Pet(initialPet.getName(), initialPet.getHunger(), initialPet.getBoredom(),
								initialPet.getDirtiness());
					} else {
						System.exit(0);
					}
				}
			} else if (userResponse == 5) {
				/*
				 * Exit option
				 */
				System.out.printf("Would you like to save your pet to a file?");
				User_Interface.printOptions(new String[] { "Yes", "No" });

				userResponse = getChoice(input, 2);

				if (userResponse == 1) {
					// Consumes new line character
					input.nextLine();

					while (true) {
						System.out.printf("Enter a file path: ");
						String filePath = input.nextLine();
						if (pet.SaveToFile(filePath, pet)) {
							System.out.printf("Done!");
							System.exit(0);
						} else {
							ui.clearScreen();
							System.out.printf("Invalid file path!%n");
						}
					}
				} else {
					System.exit(0);
				}
			}
		}
	}
}