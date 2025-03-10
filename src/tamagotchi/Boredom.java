package tamagotchi;

/**
 * Class to manage the activities that can influence the boredom value of a
 * virtual pet
 * 
 * @author Isla Purkey
 */
public class Boredom {
	int gameSelected = 1;
	boolean gameOngoing = false;

	/**
	 * Default constructor
	 */
	public Boredom() {
		// TODO
	}

	/**
	 * Returns the possible boredom decrease if the current activity/game is won by
	 * the player
	 * 
	 * @param selectedActivity The current activity/game the user has selected
	 * @return The amount the boredom statistic will decrease
	 */
	public int getBoredomDecrease(String selectedActivity) {
		// TODO
		return 0;
	}

	/**
	 * Provides the user with the current ongoing game
	 * 
	 * @return The current game being played
	 */
	public String getGame() {
		// TODO
		return "";
	}

	/**
	 * Sets the current game to the game the user provides
	 * 
	 * @param game The game to be set
	 */
	public void setGame(String game) {
		// TODO
	}

	/**
	 * Starts the currently set game
	 */
	public void startGame() {

	}

	/**
	 * Ends the currently ongoing game
	 */
	public void endGame() {

	}
}
