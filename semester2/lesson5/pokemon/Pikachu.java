package lesson5.pokemon;

import java.util.Random;

public class Pikachu extends Pokemon {
	static Random r = new Random();

	static int[] base = new int[] { 35, 55, 40, 50, 50, 90 };

	static String[] type = new String[] { "Electric" };

	public Pikachu() {
		super(r.nextInt(25) + 6, "Pikachu", r.nextInt(32), base, type);
	}

	public static void main(String[] args) {

	}
}