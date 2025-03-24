package tamagotchi;

/**
 * Class that represents a trivia game that is designed to be played by a
 * virtual pet
 * 
 * @authors Isla Purkey
 */

import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Trivia_Game {

	int gamesPlayed = 0;
	int gameStatus = 0; // -1 = No game running; 0 = New game; 1 = Waiting for pet input; 2 = Waiting
						// for player input;
						// 3 = Player won; 4 = Pet won; 5 = No winner; 6 = Game ended
	int questionCount = 0;

	Random question = new Random();

	String[] questionArray = { "What is the capital of Massachusetts?",
			"What is the largest planet in the solar system?", "What is the name of the tallest mountain in the world?",
			"Who was the first person to walk on the moon?", "Who was the first president of the United States?",
			"How many letters are in the alphabet?", "What city is the Statue of Liberty located in?",
			"How many bases are there on a baseball field?", "What is the human body's largest organ?",
			"What year was Earth Day first celebrated?" }; // Default 10 questions
	String[] answerArray = { "Boston", "Jupiter", "Mount Everest", "Neil Armstrong", "George Washington", "26",
			"New York", "4", "Skin", "1970" }; // Answers to all 10 questions, in order
	String[] finalAnswerArray = new String[2]; // Contains pet and user answers to a question

	/**
	 * Default constructor
	 */
	public Trivia_Game() {
		this("default");
	}

	/**
	 * Constructor, takes a file name as input, then represents the information
	 * within that file in multiple arrays
	 * 
	 * @param fileName The name of the file that contains the questions and answers
	 */
	public Trivia_Game(String fileName) {
		String[] questionArray = new String[10];
		String[] answerArray = new String[10];
		try (Scanner fin = new Scanner(new File(fileName))) {
			while (fin.hasNextLine()) {
				for (int i = 0; i < 10; i++) {
					questionArray[i] = fin.nextLine();
				}
				for (int j = 0; j < 10; j++) {
					answerArray[j] = fin.nextLine();
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.printf("No file chosen! Game will proceed with default settings%n%n");
		}
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
	 * 
	 * @param answerThe     answer that the user has selected
	 * @param questionIndex The index of the question
	 * @return true if the user was correct, false if otherwise
	 */
	public boolean checkAnswer(String answer, int questionIndex) {
		if (answer.equals(answerArray[questionIndex])) {
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
