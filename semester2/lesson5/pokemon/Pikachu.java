package lesson5.pokemon;

import java.util.Random;

public class Pikachu extends Pokemon {
	static Random r = new Random();

	static int[] base = new int[] { 35, 55, 40, 50, 50, 90 };

	public Pikachu() {
		super(r.nextInt(25) + 6, "Pikachu", r.nextInt(32), base, "Electric");
	}

	public static void main(String[] args) {

	}
}