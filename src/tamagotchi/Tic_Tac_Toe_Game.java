package tamagotchi;

/**
 * Class that represents a Tic Tac Toe game that is designed to be played by a virtual pet
 * 
 * @author Isla Purkey
 */

import java.util.Random;

public class Tic_Tac_Toe_Game {

	String[][] gameBoard = new String[3][3];
	boolean usersChoice = true;
	int gameStatus = 0;
	Random petChoice = new Random();

	/**
	 * Constructor, creates a Tic Tac Toe object in a starting game state
	 */
	public Tic_Tac_Toe_Game() {
		// TODO
	}

	/**
	 * Has the pet generate a valid option to be put on the board
	 * 
	 * @param gameState The current board of the game
	 * @return The index of the space the pet would like to choose from top to
	 *         bottom, left to right. (Eg. 0 is the top left and 9 is the bottom
	 *         right)
	 */
	public int petChoice(String[][] gameState) {
		// TODO
		return 0;
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
	public void exitGame() {
		// TODO
	}

	/**
	 * Resets the game back to it's initial state
	 */
	public void resetGame() {
		// TODO
	}

}
