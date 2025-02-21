package tamagotchi;

/**
 * Class to manage the activities that can influence the dirtiness value of a
 * virtual pet
 * 
 * @author Isla Purkey
 */
public class Dirtiness {
	// Hard coded values for each cleaning method
	String[] cleaningType = { "Quick Rinse", "Deep Clean" };
	int[] cleaningDirtinessDecrease = { 5, 20 };

	int cleaningStatus = 0;

	/**
	 * Default constructor
	 */
	public Dirtiness() {
		// TODO
	}

	/**
	 * Provides the valid cleaning options
	 * 
	 * @return
	 */
	public String[] getCleaningOptions() {
		// TODO
		return new String[] { "" };
	}

	/**
	 * Provides the decrease of the passed in cleaning method
	 * 
	 * @param selectedClean The cleaning method
	 * @return The dirtiness statistic decrease of the provided cleaning method
	 */
	public int getDirtinessDecrease(String selectedClean) {
		// TODO
		return 0;
	}

	/**
	 * Sets the current cleaning method to the index value provided
	 * 
	 * @param selection The index of the cleaning methods array (eg. 0 = "Quick
	 *                  Rinse")
	 */
	public void selectCleaningMethod(int selection) {
		// TODO
	}
}
