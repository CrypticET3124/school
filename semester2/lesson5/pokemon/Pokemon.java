package lesson5.pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pokemon {
	public static Random r = new Random();

	public String name;
	public String[] type;

	public int lvl;
	public int[] stat = new int[6];
	public int iv;
	public int[] ev = new int[6];

	public Pokemon(int l, String n, int i, int[] b, String x) {
		this.lvl = l;
		this.name = n;
		this.iv = i;

		makeStats(b);

		type = x.split(", ");
	}

	public void makeEV() {
		for (int i = 0; i < 6; i++) {
			this.ev[i] = r.nextInt(85) + 1;
		}
	}

	public int[] makeStats(int[] b) {
		makeEV();

		this.stat[0] = (((2 * b[0] + this.iv + (this.ev[0] / 4)) * this.lvl) / 100) + this.lvl + 10;

		for (int i = 1; i < 6; i++) {
			this.stat[i] = (((2 * b[i] + this.iv + (this.ev[i] / 4)) * this.lvl) / 100) + 5;
		}

		return this.stat;
	}

	public static void main(String[] args) {
		List<Pokemon> team1 = new ArrayList<>();
		
		Pokemon pikachu = new Pikachu();
		Pokemon vulpix = new Vulpix();
		Pokemon umbreon = new Umbreon();

		team1.add(pikachu);
		team1.add(vulpix);
		team1.add(umbreon);

		for (Pokemon p : team1) {
			System.out.println(p.name + ": " + p.lvl + " " + p.iv);
			for (int i = 0; i < 6; i++) {
				System.out.print(p.stat[i] + " ");
			}
			System.out.println();
			for (int i = 0; i < 6; i++) {
				System.out.print(p.ev[i] + " ");
			}
			System.out.println();
		}
	}
}
/*
 * Ability
 * Move1
 * Move2
 * Move3
 * Move4
 */
