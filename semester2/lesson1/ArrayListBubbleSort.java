package lesson1;

import java.util.ArrayList;
import java.util.List;

public class ArrayListBubbleSort {
	static int sorts = 1;

	public static void sort(List<Integer> array) {
		for (int i = 0; i < array.size() - 1; i++) {
			if (array.get(i) > array.get(i + 1)) {
				int n1 = array.get(i);

				array.set(i, array.get(i + 1));
				array.set(i + 1, n1);

				sorts++;
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<>(List.of(2, 5, 6, 4, 10, 8, 1, 9, 3, 7));

		while (sorts != 0) {
			sorts = 0;
			sort(array);
		}
	}
}
