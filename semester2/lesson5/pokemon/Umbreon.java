package lesson5.pokemon;

import java.util.Random;

public class Umbreon extends Pokemon{
	static Random r = new Random();
	
	static int[] base = new int[] {95, 65, 110, 60, 130, 65};

	static String[] type = new String[] {"Dark"};

	public Umbreon() {
		super(r.nextInt(25) + 6, "Umbreon", r.nextInt(32), base, type);
	}
	
	public static void main(String[] args) {
		
	}
}