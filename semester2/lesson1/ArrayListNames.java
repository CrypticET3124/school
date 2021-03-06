package lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListNames {
	static int sorts = 1;

	public static void sort(List<String> al) {
		for (int i = 0; i < al.size() - 1; i++) {
			if (al.get(i).compareTo(al.get(i + 1)) > 0) {
				String s1 = al.get(i);

				al.set(i, al.get(i + 1));
				al.set(i + 1, s1);

				sorts++;
			}
		}
	}

	public static void main(String[] args) {
		String[] array = { "Zack", "Brendan", "James", "Bjorn", "Jacob", "John", "Revan" };

		ArrayList<String> al = new ArrayList<>(Arrays.asList(array));

		al.add("Dory");
		al.add("Jimmy");
		al.add("Katy");

		while (sorts != 0) {
			sorts = 0;
			sort(al);
		}
	}
}
