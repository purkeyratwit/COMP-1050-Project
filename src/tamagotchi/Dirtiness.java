package tamagotchi;

/**
 * Class to manage the activities that can influence the dirtiness value of a
 * virtual pet
 * 
 * @authors Isla Purkey
 */
public class Dirtiness {
	// Hard coded values for each cleaning method
	String[] cleaningType = { "Quick Rinse", "Deep Clean" };
	int[] cleaningDirtinessDecrease = { 5, 20 };
	int cleaningStatus = 0; // -1 =  No cleaning method ongoing; 0 = Quick Rinse ongoing; 1 = Deep Clean ongoing

	/**
	 * Default constructor
	 */
	public Dirtiness() {
		cleaningStatus = 0; 
		
	}

	/**
	 * Provides the valid cleaning options
	 * 
	 * @return
	 */
	public String[] getCleaningOptions() {
		return cleaningType;
	}

	/**
	 * Provides the decrease of the passed in cleaning method
	 * 
	 * @param selectedClean The cleaning method
	 * @return The dirtiness statistic decrease of the provided cleaning method
	 */
	public int getDirtinessDecrease(String selectedClean) {
		
		if (selectedClean == "Quick Rinse"){
			return cleaningDirtinessDecrease[0];
		} if (selectedClean == "Deep Clean") {
			return cleaningDirtinessDecrease[1];
		}
		return 0;
	}

	/**
	 * Sets the current cleaning method to the index value provided
	 * 
	 * @param selection The index of the cleaning methods array (eg. 0 = "Quick
	 *                  Rinse")
	 */
	public void selectCleaningMethod(int selection) {
		if (selection == 0) {
			
			
		} if (selection == 1) {
			
		}
	}
}
