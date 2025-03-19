package tamagotchi;

/**
 * Class that represents a virtual pet. Extends the PetStats class
 * 
 * @author Isla Purkey
 */

import java.util.Random;

public class Pet extends PetStats {
	String name = "";

	/**
	 * Default Constructor
	 */
	public Pet() {
		this("N/A");
	}

	/**
	 * Constructor, creates a pet object and names the pet according to the passed
	 * in value
	 * 
	 * @param name The name that will be assigned to the pet
	 */
	public Pet(String name) {
		super();
		this.name = name;
	}

	/**
	 * Constructor, creates a pet object and names the pet according to the passed
	 * in value. Additionally takes three integers which are assigned to the pet's
	 * starting statistics
	 * 
	 * @param name The name that will be assigned to the pet
	 */
	public Pet(String name, int hunger, int boredom, int dirtiness) {
		super(hunger, boredom, dirtiness);
		this.name = name;
	}

	/**
	 * Gets the name of the pet
	 * 
	 * @return The name of the pet
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the pets name
	 * 
	 * @param name The name that will be assigned to the pet
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Reduces the statistics of the pet. Should be used for reducing statistics
	 * over time as the player plays the game
	 */
	public void updateStats() {
		Random rand = new Random();
		hunger -= rand.nextInt(5);
		if (hunger < 0) {
			hunger = 0;
		} else if (hunger > 100) {
			hunger = 100;
		}

		boredom -= rand.nextInt(5);
		if (boredom < 0) {
			boredom = 0;
		} else if (boredom > 100) {
			boredom = 100;
		}

		dirtiness -= rand.nextInt(5);
		if (dirtiness < 0) {
			dirtiness = 0;
		} else if (dirtiness > 100) {
			dirtiness = 100;
		}

		health = (hunger + boredom + dirtiness) / 3;
	}
}
