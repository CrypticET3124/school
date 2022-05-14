package lesson1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ArrayListNumberCounter {
	public static int search(int x, List<Integer> array) {
		int total = 0;

		for (int y : array) {
			if (y == x) {
				total++;
			}
		}

		return total;
	}

	public static void main(String[] args) {
		Random r = new Random();
		Scanner in = new Scanner(System.in);

		ArrayList<Integer> array = new ArrayList<>();

		for (int i = 1; i < 100; i++) {
			array.add(r.nextInt(100) + 1);
		}

		System.out.println("Enter the number you wish to search:");

		while (!in.hasNextInt()) {
			System.out.println("That's not a number.");
			in.nextLine();
		}
		int x = in.nextInt();
		in.nextLine();

		System.out.println(search(x, array));

		in.close();
	}
}
