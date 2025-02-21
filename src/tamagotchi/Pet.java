package tamagotchi;

/**
 * Class that represents a virtual pet. Extends the PetStats class
 * 
 * @author Isla Purkey
 */
public class Pet extends PetStats {
	String name = "";

	/**
	 * Default Constructor
	 */
	public Pet() {

	}

	/**
	 * Constructor, creates a pet object and names the pet according to the passed
	 * in value
	 * 
	 * @param name The name that will be assigned to the pet
	 */
	public Pet(String name) {
		// TODO
	}

	/**
	 * Gets the name of the pet
	 * 
	 * @return The name of the pet
	 */
	public String getName() {
		// TODO
		return "";
	}

	/**
	 * Sets the pets name
	 * 
	 * @param name The name that will be assigned to the pet
	 */
	public void setName(String name) {
		// TODO?
	}

	/**
	 * Reduces the statistics of the pet. Should be used for reducing statistics
	 * over time as the player plays the game
	 */
	public void updateStats() {
		// TODO
	}
}
