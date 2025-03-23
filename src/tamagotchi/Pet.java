package tamagotchi;

/**
 * Class that represents a virtual pet. Extends the PetStats class
 * 
 * @author Isla Purkey
 */

import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

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
	 * @param name      The name that will be assigned to the pet
	 * @param hunger    The hunger value that will be assigned to the pet
	 * @param boredom   The boredom value that will be assigned to the pet
	 * @param dirtiness The dirtiness value that will be assigned to the pet
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

	/**
	 * Saves the pet data to a file provided
	 * 
	 * @param filePath The file path of the file
	 * @return True if the file was written successfully, false otherwise
	 */
	public boolean SaveToFile(String filePath, Pet pet) {
		try (PrintWriter fout = new PrintWriter(filePath)) {
			// Name, hunger, boredom, dirtiness, health
			fout.printf("PETFILE%n");
			fout.printf("%s%n", pet.getName());
			fout.printf("%d%n%d%n%d%n%f", pet.getHunger(), pet.getBoredom(), pet.getDirtiness(), pet.getHealth());

			return true;
		} catch (IOException ex) {
			return false;
		}
	}

	public static Pet readFromFile(String filePath, Scanner input) {
		while (true) {
			try (Scanner fin = new Scanner(new File(filePath))) {
				if (fin.nextLine().equals("PETFILE")) {
					int h, b, d;
					String n = fin.nextLine();
					h = fin.nextInt();
					b = fin.nextInt();
					d = fin.nextInt();
					return new Pet(n, h, b, d);
				} else {
					System.out.printf("Invalid file information!%n");
				}
			} catch (IOException e) {
				System.out.printf("Invalid file path!%n");
			}

			System.out.printf("Enter a valid .txt file path ('abort' to abort): ");
			filePath = input.nextLine();
			if (filePath.equals("abort")) {
				return new Pet();
			}
		}
	}
}
