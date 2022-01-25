public class StringBubbleSort {
	static int sorts = 1;

	public static void sort(String[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i].compareTo(array[i + 1]) > 0) {
				String s1 = array[i];

				array[i] = array[i + 1];
				array[i + 1] = s1;

				sorts++;
			}
		}
	}

	public static void main(String[] args) {
		String[] array = {"Chirs", "Bob", "Mary", "Taco", "Phone", "Watch"};

		while (sorts != 0) {
			sorts = 0;
			sort(array);
		}
	}
}
