package tamagotchi;

public class PetStats {

	public int hunger = 0;
	public int boredom = 0;
	public int dirtiness = 0;
	public double health = 0;

	public PetStats() {
		this(50, 50, 50);
	}

	public PetStats(int hunger, int boredom, int dirtiness) {
		this.hunger = hunger;
		this.boredom = boredom;
		this.dirtiness = dirtiness;

		// Sets the default health value to the average of the three arguments
		this.health = (hunger + boredom + dirtiness) / 3.0;
	}

	public int getHunger() {
		return hunger;
	}

	public int getBoredom() {
		return boredom;
	}

	public int getDirtiness() {
		return dirtiness;
	}

	public double getHealth() {
		return health;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public void setBoredom(int boredom) {
		this.boredom = boredom;
	}

	public void setDirtiness(int dirtiness) {
		this.dirtiness = dirtiness;
	}

	public void setHealth(double health) {
		this.health = health;
	}

}
