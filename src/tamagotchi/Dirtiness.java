package tamagotchi;

public class Dirtiness {
	// Hard coded values for each cleaning method
	String[] cleaningType = { "Quick Rinse", "Deep Clean" };
	int[] cleaningDirtinessDecrease = { 5, 20 };

	int cleaningStatus = 0;

	public Dirtiness() {
		// TODO
	}

	public String[] getCleaningOptions() {
		// TODO
		return new String[] { "" };
	}

	public int getDirtinessDecrease(String selectedClean) {
		// TODO
		return 0;
	}

	public void selectCleaningMethod(int selection) {
		// TODO
	}
}
