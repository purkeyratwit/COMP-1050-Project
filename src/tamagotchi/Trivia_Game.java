package tamagotchi;

/**
 * Class that represents a trivia game that is designed to be played by a
 * virtual pet
 * 
 * @authors Isla Purkey; Jade Horne
 */
public class Trivia_Game {
	
	int gamesPlayed = 0;
	int gameStatus = 0;
	int questionCount = 0;

	/**
	 * Default constructor
	 */
	public Trivia_Game() {
		this("default");
	}

	/**
	 * Constructor, takes a file name as input, then represents the information within
	 * that file in multiple arrays
	 * 
	 * @param fileName The name of the file that contains the questions and answers
	 */
	public Trivia_Game(String fileName) {
		// TODO
		String[] questionArray = new String[0];
		String[] choicesArray = new String[0];
		String[] answerArray = new String[0];
	}

	/**
	 * Picks a random question out of the list of questions provided
	 * 
	 * @param questionArray The array which contains the questions that are able to
	 *                      be selected
	 * @return The index of the selected question
	 * 
	 */
	public int pickQuestion(String[] questionArray) {
		// TODO
		return 0;
	}

	/**
	 * Check if the answer provided matches the correct answer
	 * 
	 * @param answer        The answer that the user has selected
	 * @param questionIndex The index of the question
	 * @return true if the user was correct, false if otherwise
	 */
	public boolean checkAnswer(String answer, int questionIndex) {
		// TODO
		return false;
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
		gamesPlayed = 0;
		gameStatus = 0; 
		questionCount = 0;
	}

}
