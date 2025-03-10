package tamagotchi;

import java.util.Random;

public class Pet extends PetStats {
	String name = "";

	public Pet() {
		this("N/A");
	}

	public Pet(String name) {
		super();
		this.name = name;
	}
	
	public Pet(String name, int hunger, int boredom, int dirtiness) {
		super(hunger, boredom, dirtiness);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void updateStats() {
		Random rand = new Random();
		hunger -= rand.nextInt(5);
		if (hunger < 0) {
			hunger = 0;
		}
		boredom -= rand.nextInt(5);
		if (boredom < 0) {
			boredom = 0;
		}
		dirtiness -= rand.nextInt(5);
		if (dirtiness < 0) {
			dirtiness = 0;
		}

		health = (hunger + boredom + dirtiness) / 3;
	}
}
