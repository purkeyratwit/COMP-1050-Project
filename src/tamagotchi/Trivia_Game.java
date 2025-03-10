package tamagotchi;

public class Trivia_Game {
	
	int gamesPlayed = 0;
	int gameStatus = 0;
	int questionCount = 0;

	public Trivia_Game() {
		this("default");
	}

	public Trivia_Game(String fileName) {
		// TODO
		String[] questionArray = new String[0];
		String[] choicesArray = new String[0];
		String[] answerArray = new String[0];
	}

	public int pickQuestion(String[] questionArray) {
		// TODO
		return 0;
	}

	public boolean checkAnswer(String answer, int questionIndex) {
		// TODO
		return false;
	}

	public void exitGame() {
		// TODO
	}

	public void resetGame() {
		// TODO
	}

}
