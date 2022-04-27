package lesson5.pokemon;

import java.util.Random;

public class Vulpix extends Pokemon {
	static Random r = new Random();

	static int[] base = new int[] { 38, 41, 40, 50, 65, 65 };

	public Vulpix() {
		super(r.nextInt(25) + 6, "Vulpix", r.nextInt(32), base, "Fire");
	}

	public static void main(String[] args) {

	}
}