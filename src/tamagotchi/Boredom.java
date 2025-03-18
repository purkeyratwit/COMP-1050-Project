package tamagotchi;

/**
 * Class to manage the activities that can influence the boredom value of a
 * virtual pet
 * 
 * @author Isla Purkey
 */
public class Boredom {
	int gameSelected = 0; // 0 = No game, 1 = Tic Tac Toe, 2 = Trivia
	boolean gameOngoing = false;
	String[] gameMenuOptions = new String[] { "Play Tic Tac Toe", "Play a Trivia Game", "Return to the Main Menu" };

	/**
	 * Default constructor
	 */
	public Boredom() {
		gameSelected = 0;
		gameOngoing = false;
	}

	/**
	 * Returns the possible boredom decrease if the current activity/game is won by
	 * the player
	 * 
	 * @param selectedActivity The current activity/game the user has selected
	 * @return The amount the boredom statistic will decrease
	 */
	public int getBoredomDecrease(int selectedActivity) {
		if (selectedActivity == 1) {
			return 20;
		} else if (selectedActivity == 2) {
			return 30;
		}
		return 0;
	}

	/**
	 * Provides the user with the current ongoing game
	 * 
	 * @return The current game being played
	 */
	public String getGame() {
		if (gameSelected == 1) {
			return "Tic Tac Toe";
		} else if (gameSelected == 2) {
			return "Trivia";
		}
		return "No game";
	}

	/**
	 * Sets the current game to the game the user provides
	 * 
	 * @param game The game to be set
	 */
	public void setGame(int game) {
		if (!gameOngoing) {
			gameSelected = game;
		}
	}

	/**
	 * Starts the currently set game
	 */
	public void startGame() {
		gameOngoing = true;
	}

	/**
	 * Ends the currently ongoing game
	 */
	public void endGame() {
		gameOngoing = false;
	}
}
