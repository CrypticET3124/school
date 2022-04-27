package lesson5.pokemon;

import java.util.Random;

public class Pokemon {
	public static Random r = new Random();

	public String name;
	public String[] type;
	
	public int lvl;
	public int[] stat;
	public int iv;
	public int[] ev;

	public Pokemon(int l, String n, int i, int[] b, String[] t) {
		this.lvl = l;
		this.name = n;
		this.iv = i;
		this.type = t;

		makeStats(b);
	}

	public void makeEV() {
		for(int i = 0; i < 6; i++) {
			this.ev[i] = r.nextInt(85)+1;
		}
	}
	
	public int[] makeStats(int[] b) { // maybe remove "this."
		makeEV();
		
		this.stat[0] = ( (2 * b[0] + this.iv + (this.ev[0]/4) * this.lvl) / 100 ) + this.lvl + 10;
			
		for(int i = 1; i < 6; i++) {
			this.stat[i] = ( (2 * b[i] + this.iv + (this.ev[i]/4) * this.lvl) / 100) + 5;
		}

		return this.stat;
	}
	
	public static void main(String[] args) {
		
	}
}
/*
	Health
	Attack
	Defense
	Special Attack
	Special Defense
	Speed
	Ability
	Move1
	Move2
	Move3
	Move4
	Types (Poison, Grass, etc)
*/
