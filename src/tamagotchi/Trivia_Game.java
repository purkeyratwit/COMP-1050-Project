package tamagotchi;

/**
 * Class that represents a trivia game that is designed to be played by a
 * virtual pet
 * 
 * @authors Isla Purkey
 */

import java.util.Random;
import java.util.Scanner; 
public class Trivia_Game {
	
	int gamesPlayed = 0;
	int gameStatus = 0; // -1 = No game running; 0 = New game; 1 = Waiting for pet input; 2 = Waiting for player input; 
						// 3 = Player won; 4 = Pet won; 5 = No winner; 7 = Game ended
	int questionCount = 0;

	Random question = new Random();
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
		String[] questionArray = new String[10]; // 10 questions are used from a given file
		String[] choicesArray = new String[3]; // Each question has three answer choices
		String[] answerArray = new String[2]; // Contains pet and user answers to a question
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
		return question.nextInt(10);
	}

	/**
	 * Check if the answer provided matches the correct answer
	 
	 * @param answer        The answer that the user has selected
	 * @param questionIndex The index of the question
	 * @return true if the user was correct, false if otherwise
	 */
	public boolean checkAnswer(String answer, int questionIndex) {
		if (answer == questionArray[questionIndex]) {
			return true; 
		}
		return false;
	}

	/**
	 * Exits the game
	 */
	public void exitGame() {
		gameStatus = -1;
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
