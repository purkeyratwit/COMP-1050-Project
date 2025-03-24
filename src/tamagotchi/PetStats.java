package tamagotchi;

/**
 * Class that represents statistics that are relevant to a virtual pet
 * 
 * @author Isla Purkey
 */
public class PetStats {

	public int hunger = 0;
	public int boredom = 0;
	public int dirtiness = 0;
	public double health = 0;

	/**
	 * Default constructor
	 */
	public PetStats() {
		this(50, 50, 50);
	}

	/**
	 * Constructor, takes 3 integers as parameters to represent the starting value
	 * of each statistic
	 * 
	 * @param hunger    The starting value for the pets hunger
	 * @param boredom   The starting value for the boredom hunger
	 * @param dirtiness The starting value for the dirtiness hunger
	 */
	public PetStats(int hunger, int boredom, int dirtiness) {
		this.hunger = hunger;
		this.boredom = boredom;
		this.dirtiness = dirtiness;

		// Sets the default health value to the average of the three arguments
		this.health = (hunger + boredom + dirtiness) / 3.0;
	}

	/**
	 * Provides the user with the current hunger value of the pet
	 * 
	 * @return The current hunger value
	 */
	public int getHunger() {
		return hunger;
	}

	/**
	 * Provides the user with the current boredom value of the pet
	 * 
	 * @return The current boredom value
	 */
	public int getBoredom() {
		return boredom;
	}

	/**
	 * Provides the user with the current dirtiness value of the pet
	 * 
	 * @return The current dirtiness value
	 */
	public int getDirtiness() {
		return dirtiness;
	}

	/**
	 * Provides the user with the current health value of the pet
	 * 
	 * @return The current health value
	 */
	public double getHealth() {
		return health;
	}

	/**
	 * Sets the hunger value to the value the user provides
	 */
	public void setHunger(int hunger) {
		if (hunger >= 100) {
			this.hunger = 100;
		} else if (hunger <= 0) {
			this.hunger = 0;
		} else {
			this.hunger = hunger;
		}
	}

	/**
	 * Sets the boredom value to the value the user provides
	 */
	public void setBoredom(int boredom) {
		if (boredom >= 100) {
			this.boredom = 100;
		} else if (boredom <= 0) {
			this.boredom = 0;
		} else {
			this.boredom = boredom;
		}
	}

	/**
	 * Sets the dirtiness value to the value the user provides
	 */
	public void setDirtiness(int dirtiness) {
		if (dirtiness >= 100) {
			this.dirtiness = 100;
		} else if (dirtiness <= 0) {
			this.dirtiness = 0;
		} else {
			this.dirtiness = dirtiness;
		}
	}

	/**
	 * Sets the health value to the value the user provides
	 */
	public void setHealth(double health) {
		if (health >= 100) {
			this.health = 100;
		} else if (health <= 0) {
			this.health = 0;
		} else {
			this.health = health;
		}
	}

}
