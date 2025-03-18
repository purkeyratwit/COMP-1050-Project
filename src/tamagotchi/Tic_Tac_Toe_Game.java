package tamagotchi;

/**
 * Class that represents a Tic Tac Toe game that is designed to be played by a virtual pet
 * 
 * @author Isla Purkey
 */

import java.util.Random;
import java.util.ArrayList;

public class Tic_Tac_Toe_Game {

	String[][] gameBoard = new String[3][3];
	boolean usersChoice = true;
	int gameStatus = 0; // -1 = No game running, 0 = New game, 1 = Waiting for x input, 2 = Waiting for
						// y input, 3 = Pet making a choice, 4 = Game ended
	Random petChoice = new Random();

	/**
	 * Constructor, creates a Tic Tac Toe object in a starting game state
	 */
	public Tic_Tac_Toe_Game() {
		gameStatus = 0;
		usersChoice = true;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gameBoard[i][j] = " ";
			}
		}
	}

	/**
	 * Has the pet generate a valid option to be put on the board
	 * 
	 * @param gameState The current board of the game
	 * @return An array of the indexes of the space the pet would like to choose
	 *         from. The first number is the y coordinate (0-2) and the second
	 *         number is the x coordinate (0-2)
	 */
	public int[] petChoice(String[][] gameState) {
		while (true) {
			int x = petChoice.nextInt(3);
			int y = petChoice.nextInt(3);
			if (validOption(x + 1, y + 1)) {
				return new int[] { y, x };
			}
		}
	}

	/**
	 * Checks if there is currently a winner on the game board
	 * 
	 * @return Returns if the user, pet, or nobody has won
	 */
	public String checkWinner() {
		// TODO
		return "";
	}

	/**
	 * Exits the game
	 */
	public String[] getValidOptions() {
		ArrayList<String> returnArray = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (gameBoard[i][j].equals(" ")) {
					returnArray.add(String.format("%d, %d", i + 1, j + 1));
				}
			}
		}
		return returnArray.toArray(new String[returnArray.size()]);
	}

	public boolean validOption(int x, int y) {
		if ((gameBoard[y - 1][x - 1].equals("X")) || (gameBoard[y - 1][x - 1].equals("O"))) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Resets the game back to it's initial state
	 */
	public void resetGame() {
		gameStatus = 0;
		usersChoice = true;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gameBoard[i][j] = " ";
			}
		}
	}

}
